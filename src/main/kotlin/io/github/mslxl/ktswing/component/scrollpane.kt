package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.ChildrenScope
import java.awt.Component
import java.awt.Container
import java.awt.ScrollPane
import javax.swing.JScrollPane

class ScrollPaneScope<T : JScrollPane>(self: T) : ChildrenScope<T>(self) {
    override fun add(component: Component) {
        self.setViewportView(component)
    }
}

inline fun <T : Container> ChildrenScope<T>.scrollPane(block: ScrollPaneScope<JScrollPane>.() -> Unit): JScrollPane {
    val pane = JScrollPane()
    ScrollPaneScope(pane).apply(block)
    self.add(pane)
    return pane
}
