@file:Suppress("unused")
package io.github.mslxl.ktswing.layout

import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import java.awt.Container
import java.awt.FlowLayout

class FlowLayoutScope<T : Container>(val layout: FlowLayout, self: T) : ChildrenScope<T>(self) {
    init {
        self.layout = layout
    }
}

fun <T : Container> flowLayout(
    align: Int = 1,
    hGap: Int = 5,
    vGap: Int = 5,
): LayoutScopeWrapper<T, FlowLayoutScope<T>> {
    val layout = FlowLayout(align, hGap, vGap)
    return { it: T -> FlowLayoutScope(layout, it) }
}

inline fun <T : Container> ContainerScope<T>.flowLayout(
    align: Int = 1,
    hGap: Int = 5,
    vGap: Int = 5,
    block: FlowLayoutScope<T>.() -> Unit
): FlowLayout {
    return flowLayout<T>(align, hGap, vGap).invoke(self).apply(block).layout
}
