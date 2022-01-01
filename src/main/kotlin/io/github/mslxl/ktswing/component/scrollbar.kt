package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.JScrollBar

inline fun ChildrenScope<*>.scrollbar(orient: Int = 0, block: BasicScope<JScrollBar>.() -> Unit) =
    applyComponent(JScrollBar(orient), block)

inline fun ChildrenScope<*>.scrollbar(
    orient: Int = 0,
    value: Int = 0,
    extent: Int = 10,
    min: Int = 0,
    max: Int = 100,
    block: BasicScope<JScrollBar>.() -> Unit
) = applyComponent(JScrollBar(orient, value, extent, min, max), block)


fun ChildrenScope<*>.scrollbar(orient: Int = 0) = scrollbar(orient) {}

fun ChildrenScope<*>.scrollbar(
    orient: Int = 0,
    value: Int = 0,
    extent: Int = 10,
    min: Int = 0,
    max: Int = 100,
) = scrollbar(orient, value, extent, min, max) {}
