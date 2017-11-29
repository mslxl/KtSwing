package io.github.mslxl.ktswing

import javafx.scene.control.RadioButton
import java.awt.Component
import java.awt.Container
import java.util.*
import javax.swing.*
import javax.swing.tree.TreeNode


inline fun Content.label(text: String = "", init: JLabel.() -> Unit) = __ktswing(JLabel(text), this, init)
fun Content.label(text: String = "") = label(text) {}

inline fun Content.label(icon: Icon, init: JLabel.() -> Unit) = __ktswing(JLabel(icon), this, init)
fun Content.label(icon: Icon) = label(icon) {}

inline fun Content.textfield(text: String = "", init: JTextField.() -> Unit) = __ktswing(JTextField(text), this, init)
fun Content.textfield(text: String = ""): JTextField = textfield(text) {}


inline fun Content.textarea(text: String = "", init: JTextArea.() -> Unit) = __ktswing(JTextArea(text), this, init)
fun Content.textarea(text: String = ""): JTextArea = textarea(text) {}

inline fun Content.button(text: String = "", icon: Icon? = null, init: JButton.() -> Unit) = __ktswing(JButton(text, icon), this, init)
fun Content.button(text: String = "", icon: Icon? = null) = button(text, icon) {}

inline fun <E> Content.list(init: JList<E>.() -> Unit) = __ktswing(JList<E>(), this, init)
fun Content.list() = list<kotlin.Any>() {}

inline fun Content.scrollPane(init: Content.() -> Unit) = _createContent { __ktswing(JScrollPane(it), this) {} }.apply(init)

inline fun Content.checkBox(text: String = "", icon: Icon? = null, init: JCheckBox.() -> Unit) = __ktswing(JCheckBox(text, icon), this, init)
fun Content.checkBox(text: String = "", icon: Icon? = null) = checkBox(text, icon) {}

inline fun Content.radioButton(text: String = "", icon: Icon? = null, init: JRadioButton.() -> Unit) = __ktswing(JRadioButton(text, icon), this, init)
fun Content.radioButton(text: String = "", icon: Icon? = null) = radioButton(text, icon) {}

inline fun <E> Content.comboBox(init: JComboBox<E>.() -> Unit) = __ktswing(JComboBox<E>(), this, init)
fun Content.comboBox() = comboBox<kotlin.Any>() {}

inline fun Content.scrollBar(init: JScrollBar.() -> Unit) = __ktswing(JScrollBar(), this, init)
fun Content.scrollBar() = scrollBar() {}

inline fun Content.progressBar(init: JProgressBar.() -> Unit) = __ktswing(JProgressBar(), this, init)
fun Content.progressBar() = progressBar() {}

inline fun Content.slider(init: JSlider.() -> Unit) = __ktswing(JSlider(), this, init)
fun Content.slider() = slider() {}

inline fun Content.spinner(init: JSpinner.() -> Unit) = __ktswing(JSpinner(), this, init)
fun Content.spinner() = spinner() {}

class _SplitPane(newOrientation: Int,
                 newContinuousLayout: Boolean,
                 newLeftComponent: Component,
                 newRightComponent: Component) : JSplitPane(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent) {
    val _left = _createContent { setLeftComponent(it) }
    val _right = _createContent { setRightComponent(it) }
    inline fun top(init:Content.()->Unit){
        this.setOrientation(JSplitPane.VERTICAL_SPLIT)
        _left.apply(init)
    }
    inline fun bottom(init:Content.()->Unit){
        this.setOrientation(JSplitPane.VERTICAL_SPLIT)
        _right.apply(init)
    }
    inline fun left(init:Content.()->Unit){
        setOrientation(JSplitPane.HORIZONTAL_SPLIT)
        _left.apply(init)
    }
    inline fun right(init:Content.()->Unit){
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT)
        _right.apply(init)
    }
}

inline fun Content.splitPane(newOrientation: Int = JSplitPane.HORIZONTAL_SPLIT,
                             newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
                             newLeftComponent: Component = JButton(UIManager.getString("SplitPane.leftButtonText")),
                             newRightComponent: Component = JButton(UIManager.getString("SplitPane.rightButtonText")), init: _SplitPane.() -> Unit):JSplitPane = __ktswing(_SplitPane(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent), this, init)
fun Content.splitPane(newOrientation: Int = JSplitPane.HORIZONTAL_SPLIT,
                      newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
                      newLeftComponent: Component = JButton(UIManager.getString("SplitPane.leftButtonText")),
                      newRightComponent: Component = JButton(UIManager.getString("SplitPane.rightButtonText"))) = splitPane(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent) {}

inline fun Content.tree(init:JTree.()->Unit)= __ktswing(JTree(),this,init)
inline fun Content.tree(value:Array<Any>,init:JTree.()->Unit)= __ktswing(JTree(value),this,init)
inline fun Content.tree(value:Vector<*>,init:JTree.()->Unit)= __ktswing(JTree(value),this,init)
inline fun Content.tree(root: TreeNode, asksAllowsChildren:Boolean=false,init:JTree.()->Unit)= __ktswing(JTree(root,asksAllowsChildren),this,init)
fun Content.tree()=tree(){}

