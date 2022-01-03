package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.ChildrenScope
import java.awt.Component
import java.awt.Container
import javax.swing.JScrollPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class ScrollPaneScope<T : JScrollPane>(self: T) : ChildrenScope<T>(self) {
    override fun add(component: Component) {
        self.setViewportView(component)
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> ChildrenScope<T>.scrollPane(block: ScrollPaneScope<JScrollPane>.() -> Unit): JScrollPane {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val pane = JScrollPane()
    ScrollPaneScope(pane).apply(block)
    self.add(pane)
    return pane
}
