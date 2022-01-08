package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.JToolBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.toolBar(
    name: String? = null,
    orient: Int = JToolBar.HORIZONTAL,
    block: CanAddChildrenScope<JToolBar>.() -> Unit
): JToolBar {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val scope = CanAddChildrenScope(JToolBar(name, orient)).apply(block)
    add(scope.self)
    return scope.self
}

fun CanAddChildrenScope<*>.toolBar(
    name: String? = null,
    orient: Int = JToolBar.HORIZONTAL,
) = toolBar(name, orient) {}
