package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.group.SwingComponentBuilderScope
import io.github.mslxl.ktswing.group.swing
import java.awt.Component
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTabbedPane

class TabbedPaneScope(self: JTabbedPane) : BasicScope<JTabbedPane>(self) {
    fun tab(name: String, block: ContainerScope<JPanel>.() -> Unit) {
        self.add(name, swing {
            panel(block)
        })
    }
}

inline fun ChildrenScope<*>.tabbedPane(
    tabPlacement: Int = JTabbedPane.TOP,
    tabLayoutPolicy: Int = JTabbedPane.WRAP_TAB_LAYOUT,
    block: TabbedPaneScope.() -> Unit
): JTabbedPane {
    val pane = JTabbedPane(tabPlacement, tabLayoutPolicy)
    TabbedPaneScope(pane).apply(block)
    self.add(pane)
    return pane
}