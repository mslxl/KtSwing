@file:Suppress("unused")
package io.github.mslxl.ktswing.layout

import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.CanSetLayoutScope
import io.github.mslxl.ktswing.LayoutScope
import java.awt.Container
import java.awt.FlowLayout
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class FlowLayoutScope<T : Container>(val layout: FlowLayout, override val self: T) : CanAddChildrenScope<T>,
    LayoutScope {
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

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> CanSetLayoutScope<T>.flowLayout(
    align: Int = 1,
    hGap: Int = 5,
    vGap: Int = 5,
    block: FlowLayoutScope<T>.() -> Unit
): FlowLayout {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return flowLayout<T>(align, hGap, vGap).invoke(self).apply(block).layout
}
