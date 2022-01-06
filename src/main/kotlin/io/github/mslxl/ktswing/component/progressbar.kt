package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.BoundedRangeModel
import javax.swing.JProgressBar

inline fun CanAddChildrenScope<*>.progressBar(orient: Int = 0, block: BasicScope<JProgressBar>.() -> Unit) =
    applyComponent(JProgressBar(orient), block)

inline fun CanAddChildrenScope<*>.progressBar(
    orient: Int = 0,
    min: Int,
    max: Int,
    block: BasicScope<JProgressBar>.() -> Unit
) =
    applyComponent(JProgressBar(orient, min, max), block)

inline fun CanAddChildrenScope<*>.progressBar(model: BoundedRangeModel, block: BasicScope<JProgressBar>.() -> Unit) =
    applyComponent(JProgressBar(model), block)

fun CanAddChildrenScope<*>.progressBar(orient: Int = 0) =
    progressBar(orient) {}

fun CanAddChildrenScope<*>.progressBar(
    orient: Int = 0,
    min: Int,
    max: Int,
) =
    progressBar(orient, min, max) {}

fun CanAddChildrenScope<*>.progressBar(model: BoundedRangeModel) =
    progressBar(model) {}
