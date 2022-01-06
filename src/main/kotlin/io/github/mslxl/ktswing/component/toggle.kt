package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.Icon
import javax.swing.JToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.toggleButton(
    text: String,
    selected: Boolean = false,
    block: BasicScope<JToggleButton>.() -> Unit
): JToggleButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JToggleButton(text, selected), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.toggleButton(
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JToggleButton>.() -> Unit
): JToggleButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JToggleButton(icon, selected), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.toggleButton(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JToggleButton>.() -> Unit
): JToggleButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JToggleButton(text, icon, selected), block)
}

fun CanAddChildrenScope<*>.toggleButton(text: String) =
    toggleButton(text) {}

fun CanAddChildrenScope<*>.toggleButton(icon: Icon) =
    toggleButton(icon) {}

fun CanAddChildrenScope<*>.toggleButton(text: String, icon: Icon) =
    toggleButton(text, icon) {}
