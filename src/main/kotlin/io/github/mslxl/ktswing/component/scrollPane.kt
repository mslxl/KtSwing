package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.CanAddChildrenScope
import java.awt.Component
import java.awt.Container
import javax.swing.JScrollPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class ScrollPaneScope(override val self: JScrollPane) : CanAddChildrenScope<JScrollPane> {
    override fun add(component: Component) {
        self.setViewportView(component)
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> CanAddChildrenScope<T>.scrollPane(block: ScrollPaneScope.() -> Unit): JScrollPane {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val pane = JScrollPane()
    ScrollPaneScope(pane).apply(block)
    add(pane)
    return pane
}
