package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.JSpinner
import javax.swing.SpinnerModel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.spinner(block: BasicScope<JSpinner>.() -> Unit): JSpinner {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JSpinner(), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.spinner(
    model: SpinnerModel,
    block: BasicScope<JSpinner>.() -> Unit
): JSpinner {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JSpinner(model), block)
}

fun CanAddChildrenScope<*>.spinner() = spinner { }
fun CanAddChildrenScope<*>.spinner(model: SpinnerModel) = spinner(model) {}
