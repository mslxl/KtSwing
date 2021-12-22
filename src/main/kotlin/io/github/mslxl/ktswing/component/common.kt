
package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import java.awt.Component
import java.awt.Container

inline fun <T : Component> ChildrenScope<*>.applyComponent(component: T, block: BasicScope<T>.() -> Unit): T {
    val scope = BasicScope(component).apply(block)
    add(scope.self)
    return scope.self
}

inline fun <T : Container> ChildrenScope<*>.applyContainer(component: T, block: ContainerScope<T>.() -> Unit): T {
    val scope = ContainerScope(component).apply(block)
    add(scope.self)
    return scope.self
}
