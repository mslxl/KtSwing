package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.group.swing
import javax.swing.JPanel
import javax.swing.JTabbedPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class TabbedPaneScope(self: JTabbedPane) : BasicScope<JTabbedPane>(self) {
    fun tab(name: String, block: ContainerScope<JPanel>.() -> Unit) {
        self.add(name, swing {
            panel(block)
        })
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.tabbedPane(
    tabPlacement: Int = JTabbedPane.TOP,
    tabLayoutPolicy: Int = JTabbedPane.WRAP_TAB_LAYOUT,
    block: TabbedPaneScope.() -> Unit
): JTabbedPane {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val pane = JTabbedPane(tabPlacement, tabLayoutPolicy)
    TabbedPaneScope(pane).apply(block)
    add(pane)
    return pane
}