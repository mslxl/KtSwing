package io.github.mslxl.ktswing

import java.awt.Component
import java.awt.Container
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import javax.swing.JComponent
import javax.swing.JFrame

interface Content {
    fun onAddToContent(comp: JComponent)

    infix fun Content.include(ui: UI): UI {
        this.onAddToContent(ui.view)
        return ui
    }

    infix fun Content.include(comp: JComponent): JComponent {
        this.onAddToContent(comp)
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

inline fun <E : JComponent> __ktswing(comp: E, parent: Content, init: E.() -> Unit): E {
    comp.addPropertyChangeListener(AutoCacheListener)
    parent.onAddToContent(comp)
    init.invoke(comp)
    comp.repaint()
    comp.validate()
    comp.updateUI()

    return comp
}

fun __ktswingPanelAdd(panel: BasePanel, container: Container) {
    if (container is JFrame) {
        container.contentPane = panel
    } else if (container is Content) {
        (container as Content).onAddToContent(panel)
    } else {
        container.add(panel)
    }
}

inline fun <F : BasePanel> __ktswingPanel(panel: F, container: Container, init: F.() -> Unit): BasePanel {
    __ktswingPanelAdd(panel, container)
    init.invoke(panel)
    return panel
}

fun _createContent(onAdd: (comp: JComponent) -> Unit): Content {
    return object : Content {
        override fun onAddToContent(comp: JComponent) {
            onAdd.invoke(comp)
        }
    }
}

class _UIContent(internal val init: _UIContent.() -> Unit) : Content {

    var _view: JComponent? = null
        get() {
            if (field == null) {
                init.invoke(this)
            }
            return field
        }
    var _template: Template? = null
    private var hasChild = false

    override fun onAddToContent(comp: JComponent) {
        if (!hasChild){
            _view = comp
            hasChild=true
        }
        else
            error("ui can only be one child")
    }

    class Template(private val content: _UIContent) {
        private val map = HashMap<String, Pair<String, (value: Any, comp: JComponent,prefix:String) -> Unit>>()
        fun key(key: String, componentName: String, init: (value: Any, comp: JComponent,prefix:String) -> Unit) {
            map[key] = componentName to init
        }

        fun createJComponent(name: String,vararg args: Pair<String, Any>):JComponent {
            val ui = _UIContent(content.init)
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

class UI(init: _UIContent.() -> Unit) {
    val _content = _UIContent(init)
    val view: JComponent get() = _content._view!!

    inline fun createTemplate(init: _UIContent.Template.() -> Unit): _UIContent.Template {
        synchronized(_content) {
            _content._template = _UIContent.Template(_content)
            init.invoke(_content._template!!)
            return _content._template!!
        }
    }
}