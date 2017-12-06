package io.github.mslxl.ktswing.debug

import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.event.treeSelectionListener
import java.awt.*
import java.util.*
import javax.swing.JFrame
import javax.swing.JSplitPane
import javax.swing.event.TreeModelListener
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.TreeModel
import javax.swing.tree.TreePath

fun Window.showDebugWindows() {
    Debug(this)
}

operator fun Color.not(): Color = Color(255 - red, 255 - green, 255 - blue, alpha)
private class Debug(val debugWindow: Window) : KtSwingFrame() {
    var lastSelected: DataBean? = null

    init {
        val title = if (debugWindow is Frame) debugWindow.title else "Window"
        val data = getData(debugWindow)
        setTitle("$title Debug")
        size {
            width = 600
            height = 400
        }
        cardpanel {
            splitPane {
                left {
                    tree(data) {
                        treeSelectionListener {
                            lastSelected?.let {
                                it.component.foreground = !it.component.foreground
                                it.component.background = !it.component.background
                            }
                            val selected = (lastSelectedPathComponent as DefaultMutableTreeNode).userObject as DataBean
                            selected.component.foreground = !selected.component.foreground
                            selected.component.background = !selected.component.background

                            lastSelected = selected
                        }
                    }
                }
                right {

                }
            }
        }

    }

    fun getData(node: Component): DefaultMutableTreeNode {
        val mutableTreeNode = DefaultMutableTreeNode(DataBean(node))
        if (node is Container) {
            val components = node.components
            for (it in components) {
                mutableTreeNode.add(getData(it))
            }
        }
        return mutableTreeNode
    }

    class DataBean(val component: Component) {
        val name: String
            get() = component.name ?: "NoName"

        override fun toString(): String {
            return "$name ( ${component.javaClass.name} )"
        }
    }
}