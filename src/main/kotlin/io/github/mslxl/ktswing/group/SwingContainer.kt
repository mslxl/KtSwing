package io.github.mslxl.ktswing.group

import io.github.mslxl.ktswing.ChildrenScope
import java.awt.Component
import javax.swing.JComponent
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

private object EmptyJComponent : JComponent()


class SwingComponentBuilderScope<T>() : ChildrenScope<JComponent>(EmptyJComponent) {
    var component: T? = null
    override fun add(component: Component) {
        @Suppress("UNCHECKED_CAST")
        this.component = component as T
    }
}


@OptIn(ExperimentalContracts::class)
inline fun <T> swing(block: SwingComponentBuilderScope<T>.() -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return SwingComponentBuilderScope<T>().apply(block).component!!
}
