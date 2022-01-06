package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.Icon
import javax.swing.JCheckBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.checkBox(
    text: String,
    selected: Boolean = false,
    block: BasicScope<JCheckBox>.() -> Unit
): JCheckBox {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JCheckBox(text, selected), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.checkBox(
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JCheckBox>.() -> Unit
): JCheckBox {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JCheckBox(icon, selected), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.checkBox(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JCheckBox>.() -> Unit
): JCheckBox {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JCheckBox(text, icon, selected), block)
}

fun CanAddChildrenScope<*>.checkBox(text: String) =
    checkBox(text) {}

fun CanAddChildrenScope<*>.checkBox(icon: Icon) =
    checkBox(icon) {}

fun CanAddChildrenScope<*>.checkBox(text: String, icon: Icon) =
    checkBox(text, icon) {}
