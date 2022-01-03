
@file:Suppress("unused")
package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.Icon
import javax.swing.JButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.button(text: String, block: BasicScope<JButton>.() -> Unit): JButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JButton(text), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.button(icon: Icon, block: BasicScope<JButton>.() -> Unit): JButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JButton(icon), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.button(text: String, icon: Icon, block: BasicScope<JButton>.() -> Unit): JButton {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JButton(text, icon), block)
}

fun ChildrenScope<*>.button(text: String) =
    button(text) {}

fun ChildrenScope<*>.button(icon: Icon) =
    button(icon) {}

fun ChildrenScope<*>.button(text: String, icon: Icon) =
    button(text, icon) {}
