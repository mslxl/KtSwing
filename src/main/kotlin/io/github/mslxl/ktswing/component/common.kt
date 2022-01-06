package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.CanSetLayoutScope
import java.awt.Component
import java.awt.Container
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T : Component> CanAddChildrenScope<*>.applyComponent(component: T, block: BasicScope<T>.() -> Unit): T {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    val scope = BasicScope<T>(component).apply(block)
    add(scope.self)
    return scope.self
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> CanAddChildrenScope<*>.applyContainer(
    component: T,
    block: CanSetLayoutScope<T>.() -> Unit
): T {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    val scope = CanSetLayoutScope(component).apply(block)
    add(scope.self)
    return scope.self
}
