package io.github.mslxl.ktgui.ktswing

import io.github.mslxl.ktgui.common.EndCallback
import io.github.mslxl.ktgui.common.KtDSL
import io.github.mslxl.ktgui.common.PanelNode
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import io.github.mslxl.ktgui.ktswing.component.findComponentByName
import io.github.mslxl.ktgui.ktswing.component.window

import java.awt.Container
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import javax.swing.JComponent
import javax.swing.JFrame


/**
 * Everything is extend [SwingPanelNode] in KtSwing
 * 所有的控件在 KtSwing 中都继承自 [SwingPanelNode]
 */
interface SwingPanelNode:PanelNode<JComponent> {

    /**
     * Add a [UI] to this
     * 添加一个 [UI]
     */
    infix fun include(ui: UI): UI {
        this._onAddToContent(ui.view)
        return ui
    }

    /**
     * Add a [JComponent] to this
     * 添加一个 [JComponent]
     */
    infix fun include(comp: JComponent): JComponent {
        this._onAddToContent(comp)
        return comp
    }
}

object AutoCacheListener:PropertyChangeListener {
    override fun propertyChange(it: PropertyChangeEvent) {
        if (it.propertyName == "name"){
            val component = it.source as JComponent
            val top = component.window

            if (it.oldValue!=null){
                when (top) {
                    is KtSwingFrame -> top.cache.remove(it.oldValue.toString())
                    is KtSwingDialog -> top.cache.remove(it.oldValue.toString())
                }
            }
            when (top) {
                is KtSwingFrame -> top.cache[it.newValue.toString()] = component
                is KtSwingDialog -> top.cache[it.newValue.toString()] = component
            }
        }
    }
}

/**
 * Every [JComponent] need it.
 * You need not to know what is this it.
 *
 * 你反正不需要他,管这么多干什么
 */
inline fun <E : JComponent> _ktswing(comp: E, parent: SwingPanelNode, init: E.() -> Unit): E {
    comp.addPropertyChangeListener(AutoCacheListener)
    parent._onAddToContent(comp)
    init.invoke(comp)
    comp.repaint()
    comp.validate()
    comp.updateUI()
    if (comp is EndCallback){
        comp._endCallBack()
    }
    return comp
}

/**
 * Every [Container] need it.
 * You need not to know what is this it.
 *
 * 你反正不需要他,管这么多干什么
 */
fun _ktswingPanelAdd(panel: BasePanel, container: Container) {
    when (container) {
        is JFrame -> container.contentPane = panel
        is SwingPanelNode -> (container as SwingPanelNode)._onAddToContent(panel)
        else -> container.add(panel)
    }
}

/**
 * Every [Container] need it.
 * You need not to know what is this it.
 *
 * 你反正不需要他,管这么多干什么
 */
inline fun <F : BasePanel> _ktswingPanel(panel: F, container: Container, init: F.() -> Unit): BasePanel {
    _ktswingPanelAdd(panel, container)
    init.invoke(panel)
    return panel
}

/**
 * Create an [SwingPanelNode] object and return it
 * But you need not it!!!
 *
 * 创建一个 [SwingPanelNode] 对象并返回它
 * 然而并没有什么 ~~~卯月~~~ (卵用)
 */
inline fun _createSwingPanelNode(crossinline onAdd: (comp: JComponent) -> Unit): SwingPanelNode {
    return object : SwingPanelNode {
        override fun _onAddToContent(comp: JComponent) {
            onAdd.invoke(comp)
        }
    }
}

/**
 * You need not known what is it.
 *
 * 你反正不同, 手动再见
 */
class _UIPanelNode(internal val init: _UIPanelNode.() -> Unit) : SwingPanelNode {

    var _view: JComponent? = null
        get() {
            if (field == null) {
                init.invoke(this)
            }
            return field
        }
    var _template: Template? = null
    private var hasChild = false

    override fun _onAddToContent(comp: JComponent) {
        if (!hasChild){
            _view = comp
            hasChild=true
        }
        else
            error("ui can only be one child")
    }

    /**
     * [Template] is very very strong, also it is very complex.
     *
     * You can use [Pair] that [Pair.first] is key and the [Pair.second] is value to create a [JComponent].
     *
     * But you need add the behavior with [Template.key] to process the key and value.
     *
     * See [TemplateTest.kt](https://github.com/mslxl/KtSwing/blob/master/src/test/kotlin/TemplateTest.kt) for more information.
     *
     * Fuck my English!!!
     *
     * [Template] 功能强大, 同时也十分复杂
     *
     * 你可以使用 [Pair.first] 为 key [Pair.second] 为 value 的 [Pair] 对象来创建 [JComponent].
     *
     * 但是你需要通过 [Template.key] 来添加处理 key 和 value 的行为
     *
     * 详细可见 [TemplateTest.kt](https://github.com/mslxl/KtSwing/blob/master/src/test/kotlin/TemplateTest.kt).
     *
     * 我的英语好 LJ
     */
    class Template(private val content: _UIPanelNode) {
        private val map = HashMap<String, Pair<String, (value: Any, comp: JComponent,prefix:String) -> Unit>>()
        /**
         * Add the behavior with [Template.key] to process the key and value.
         *
         * 添加处理 key 和 value 的行为
         *
         * @param key Key
         * @param componentName The component's name that you want to process it 你想处理的 Component 的 name
         * @param behavior Behavior
         */
        fun key(key: String, componentName: String, behavior: (value: Any, comp: JComponent,prefix:String) -> Unit) {
            map[key] = componentName to behavior
        }

        /**
         * Process the key and value and create [JComponent]
         *
         * Attention: Every [JComponent]'s name will add a prefix and `:` , like `name` will became `groupName:name` , the prefix is [name]
         *
         * 处理 key 和 value 并创建 [JComponent]
         *
         * 注意: 每个 [JComponent] 的名字都会添加 [name] 和 `:` 作为前缀, 像 `name` 会变为 `groupName:name`
         *
         * @param name Group name 组名
         * @param args A [Pair] that [Pair.first] is key and the [Pair.second] is value. [Pair.first] 为 key [Pair.second] 为 value 的 [Pair]
         */
        fun createJComponent(name: String,vararg args: Pair<String, Any>):JComponent {
            val ui = _UIPanelNode(content.init)
            args.forEach {
                arg->
                map[arg.first]?.let {
                    val component = ui._view!!.findComponentByName<JComponent>(it.first,false)!!
                    it.second.invoke(arg.second,component,name)
                }
            }

            fun resetName(name: String,container: Container){
                val comps = container.components
                for (it in comps) {
                    it.name = "$name:${it.name}"
                    if (it is Container){
                        resetName(name,it)
                    }
                }
            }

            resetName(name,ui._view!!)
            return ui._view!!
        }
    }
}

/**
 * Create a [JComponent] but needn't a [SwingPanelNode] object and return [UI] object.
 * Waring: [UI] only can have one child.
 *
 * 不借助 [SwingPanelNode] 对象创建 [JComponent] 并返回 [UI] 对象
 * 注意: [UI] 仅仅只能有一个子控件nanodesu!
 */
@KtDSL
class UI(init: _UIPanelNode.() -> Unit) {
    val _content = _UIPanelNode(init)
    val view: JComponent get() = _content._view!!

    /**
     * Create a [_UIPanelNode.Template] object by this object
     * 根据该对象创建 [_UIPanelNode.Template] 对象
     */
    inline fun createTemplate(init: _UIPanelNode.Template.() -> Unit): _UIPanelNode.Template {
        synchronized(_content) {
            _content._template = _UIPanelNode.Template(_content)
            init.invoke(_content._template!!)
            return _content._template!!
        }
    }
}