package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.ButtonGroup
import javax.swing.Icon
import javax.swing.JRadioButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.radioButton(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButton>.() -> Unit
): JRadioButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val btn = JRadioButton(text, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.radioButton(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButton>.() -> Unit
): JRadioButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val btn = JRadioButton(icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.radioButton(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButton>.() -> Unit
): JRadioButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val btn = JRadioButton(text, icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

fun CanAddChildrenScope<*>.radioButton(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null
) =
    radioButton(text, selected, group) {}

fun CanAddChildrenScope<*>.radioButton(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) =
    radioButton(icon, selected, group) {}

fun CanAddChildrenScope<*>.radioButton(
    text: String, icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) =
    radioButton(text, icon, selected, group) {}
