@file:JvmName("Component")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.component

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._createSwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import java.awt.Component
import java.net.URL
import java.util.*
import javax.swing.*
import javax.swing.table.TableColumnModel
import javax.swing.table.TableModel
import javax.swing.text.StyledDocument
import javax.swing.tree.TreeNode


inline fun SwingPanelNode.label(text: String = "", init: JLabel.() -> Unit) = _ktswing(JLabel(text), init)
fun SwingPanelNode.label(text: String = "") = label(text) {}

inline fun SwingPanelNode.label(icon: Icon, init: JLabel.() -> Unit) = _ktswing(JLabel(icon), init)
fun SwingPanelNode.label(icon: Icon) = label(icon) {}

inline fun SwingPanelNode.textfield(text: String = "", init: JTextField.() -> Unit) = _ktswing(JTextField(text), init)
fun SwingPanelNode.textfield(text: String = ""): JTextField = textfield(text) {}


inline fun SwingPanelNode.textarea(text: String = "", init: JTextArea.() -> Unit) = _ktswing(JTextArea(text), init)
fun SwingPanelNode.textarea(text: String = ""): JTextArea = textarea(text) {}

inline fun SwingPanelNode.button(text: String = "", icon: Icon? = null, init: JButton.() -> Unit) = _ktswing(JButton(text, icon), init)
fun SwingPanelNode.button(text: String = "", icon: Icon? = null) = button(text, icon) {}

inline fun <E> SwingPanelNode.list(init: JList<E>.() -> Unit) = _ktswing(JList<E>(), init)
fun SwingPanelNode.list() = list<kotlin.Any>() {}

inline fun SwingPanelNode.scrollPane(init: SwingPanelNode.() -> Unit):JScrollPane{
    var panel:JScrollPane? = null
    _createSwingPanelNode {
        panel=JScrollPane(it)
        _ktswing(panel!!) {}
    }.apply(init)
    return panel!!
}

inline fun SwingPanelNode.checkBox(text: String = "", icon: Icon? = null, init: JCheckBox.() -> Unit) = _ktswing(JCheckBox(text, icon), init)
fun SwingPanelNode.checkBox(text: String = "", icon: Icon? = null) = checkBox(text, icon) {}

inline fun SwingPanelNode.radioButton(text: String = "", icon: Icon? = null, init: JRadioButton.() -> Unit) = _ktswing(JRadioButton(text, icon), init)
fun SwingPanelNode.radioButton(text: String = "", icon: Icon? = null) = radioButton(text, icon) {}

inline fun <E> SwingPanelNode.comboBox(init: JComboBox<E>.() -> Unit) = _ktswing(JComboBox<E>(), init)
fun SwingPanelNode.comboBox() = comboBox<kotlin.Any>() {}

inline fun SwingPanelNode.scrollBar(init: JScrollBar.() -> Unit) = _ktswing(JScrollBar(), init)
fun SwingPanelNode.scrollBar() = scrollBar() {}

inline fun SwingPanelNode.progressBar(init: JProgressBar.() -> Unit) = _ktswing(JProgressBar(), init)
fun SwingPanelNode.progressBar() = progressBar() {}

inline fun SwingPanelNode.slider(init: JSlider.() -> Unit) = _ktswing(JSlider(), init)
fun SwingPanelNode.slider() = slider() {}

inline fun SwingPanelNode.spinner(init: JSpinner.() -> Unit) = _ktswing(JSpinner(), init)
fun SwingPanelNode.spinner() = spinner() {}

class _SplitPane(newOrientation: Int,
                 newContinuousLayout: Boolean,
                 newLeftComponent: Component,
                 newRightComponent: Component) : JSplitPane(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent) {
    val _left = _createSwingPanelNode { setLeftComponent(it) }
    val _right = _createSwingPanelNode { setRightComponent(it) }
    inline fun top(init: SwingPanelNode.() -> Unit) {
        this.setOrientation(JSplitPane.VERTICAL_SPLIT)
        _left.apply(init)
    }

    inline fun bottom(init: SwingPanelNode.() -> Unit) {
        this.setOrientation(JSplitPane.VERTICAL_SPLIT)
        _right.apply(init)
    }

    inline fun left(init: SwingPanelNode.() -> Unit) {
        setOrientation(JSplitPane.HORIZONTAL_SPLIT)
        _left.apply(init)
    }

    inline fun right(init: SwingPanelNode.() -> Unit) {
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT)
        _right.apply(init)
    }
}

inline fun SwingPanelNode.splitPane(newOrientation: Int = JSplitPane.HORIZONTAL_SPLIT,
                                    newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
                                    newLeftComponent: Component = JButton(UIManager.getString("SplitPane.leftButtonText")),
                                    newRightComponent: Component = JButton(UIManager.getString("SplitPane.rightButtonText")), init: _SplitPane.() -> Unit): JSplitPane = _ktswing(_SplitPane(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent), init)

fun SwingPanelNode.splitPane(newOrientation: Int = JSplitPane.HORIZONTAL_SPLIT,
                             newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
                             newLeftComponent: Component = JButton(UIManager.getString("SplitPane.leftButtonText")),
                             newRightComponent: Component = JButton(UIManager.getString("SplitPane.rightButtonText"))) = splitPane(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent) {}

inline fun SwingPanelNode.tree(init: JTree.() -> Unit) = _ktswing(JTree(), init)
inline fun SwingPanelNode.tree(value: Array<Any>, init: JTree.() -> Unit) = _ktswing(JTree(value), init)
inline fun SwingPanelNode.tree(value: Vector<*>, init: JTree.() -> Unit) = _ktswing(JTree(value), init)
inline fun SwingPanelNode.tree(root: TreeNode, asksAllowsChildren: Boolean = false, init: JTree.() -> Unit) = _ktswing(JTree(root, asksAllowsChildren), init)
fun SwingPanelNode.tree() = tree() {}

inline fun SwingPanelNode.table(rowData: Array<Array<*>>, columnNames: Array<Array<*>>, init: JTable.() -> Unit) = _ktswing(JTable(rowData, columnNames), init)
inline fun SwingPanelNode.table(rowData: Vector<out Vector<*>>, columnNames: Vector<*>, init: JTable.() -> Unit) = _ktswing(JTable(rowData, columnNames), init)
inline fun SwingPanelNode.table(numRows: Int, numColumns: Int, init: JTable.() -> Unit) = _ktswing(JTable(numRows, numColumns), init)
inline fun SwingPanelNode.table(dm: TableModel? = null, cm: TableColumnModel? = null, sm: ListSelectionModel? = null, init: JTable.() -> Unit) = _ktswing(JTable(dm, cm, sm), init)

class _TabbedPane(tabPlacement: Int, tabLayoutPolicy: Int) : JTabbedPane(tabPlacement, tabLayoutPolicy) {

    fun tab(name: String? = null, init: SwingPanelNode.() -> Unit) {
        init.invoke(_createSwingPanelNode {
            if (name == null) {
                add(it)
            } else {
                add(name, it)
            }
        })
    }
}

enum class TabPlacement { TOP, LEFT, BOTTOM, RIGHT }

enum class TabLayoutPolicy { WRAP_TAB_LAYOUT, SCROLL_TAB_LAYOUT }

inline fun SwingPanelNode.tabbedPane(tabPlacement: TabPlacement, tabLayoutPolicy: TabLayoutPolicy, init: _TabbedPane.() -> Unit) = _ktswing(_TabbedPane(tabPlacement.ordinal + 1, tabLayoutPolicy.ordinal + 1), init)

inline fun SwingPanelNode.textPane(init: JTextPane.() -> Unit) = _ktswing(JTextPane(), init)
inline fun SwingPanelNode.textPane(styledDocument: StyledDocument, init: JTextPane.() -> Unit) = _ktswing(JTextPane(styledDocument), init)

inline fun SwingPanelNode.editorPane(init: JEditorPane.() -> Unit) = _ktswing(JEditorPane(), init)
inline fun SwingPanelNode.editorPane(initialPage: URL, init: JEditorPane.() -> Unit) = _ktswing(JEditorPane(initialPage), init)
inline fun SwingPanelNode.editorPane(url: String, init: JEditorPane.() -> Unit) = _ktswing(JEditorPane(url), init)
inline fun SwingPanelNode.editorPane(type: String, text: String, init: JEditorPane.() -> Unit) = _ktswing(JEditorPane(type, text), init)