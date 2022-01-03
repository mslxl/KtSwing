package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.JScrollBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.scrollbar(orient: Int = 0, block: BasicScope<JScrollBar>.() -> Unit): JScrollBar {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JScrollBar(orient), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.scrollbar(
    orient: Int = 0,
    value: Int = 0,
    extent: Int = 10,
    min: Int = 0,
    max: Int = 100,
    block: BasicScope<JScrollBar>.() -> Unit
): JScrollBar {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JScrollBar(orient, value, extent, min, max), block)
}


fun ChildrenScope<*>.scrollbar(orient: Int = 0) = scrollbar(orient) {}

fun ChildrenScope<*>.scrollbar(
    orient: Int = 0,
    value: Int = 0,
    extent: Int = 10,
    min: Int = 0,
    max: Int = 100,
) = scrollbar(orient, value, extent, min, max) {}
