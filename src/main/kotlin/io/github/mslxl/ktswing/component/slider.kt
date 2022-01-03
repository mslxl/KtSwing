package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.BoundedRangeModel
import javax.swing.JSlider
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.slider(orient: Int = 0, block: BasicScope<JSlider>.() -> Unit): JSlider {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JSlider(orient), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.slider(
    min: Int = 0,
    max: Int = 100,
    value: Int = 50,
    block: BasicScope<JSlider>.() -> Unit
): JSlider {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JSlider(min, max, value), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.slider(
    orient: Int = 0,
    min: Int = 0,
    max: Int = 100,
    value: Int = 50,
    block: BasicScope<JSlider>.() -> Unit
): JSlider {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JSlider(orient, min, max, value), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.slider(model: BoundedRangeModel, block: BasicScope<JSlider>.() -> Unit): JSlider {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JSlider(model), block)
}

fun ChildrenScope<*>.slider(orient: Int = 0) =
    slider(orient) {}

fun ChildrenScope<*>.slider(
    min: Int = 0,
    max: Int = 100,
    value: Int = 50
) = slider(min, max, value) {}

fun ChildrenScope<*>.slider(
    orient: Int = 0,
    min: Int = 0,
    max: Int = 100,
    value: Int = 50
) = slider(orient, min, max, value) {}

fun ChildrenScope<*>.slider(model: BoundedRangeModel) =
    slider(model) {}
