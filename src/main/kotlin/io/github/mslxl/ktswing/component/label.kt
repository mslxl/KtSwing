@file:Suppress("unused")

package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.JLabel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<*>.label(text: String, block: BasicScope<JLabel>.() -> Unit): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JLabel(text), block)
}

fun ChildrenScope<*>.label(text: String) =
    label(text) {}


@OptIn(ExperimentalContracts::class)
fun ChildrenScope<*>.label(text: String, horizontalAlignment: Int, block: BasicScope<JLabel>.() -> Unit): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JLabel(text, horizontalAlignment), block)
}

fun ChildrenScope<*>.label(text: String, horizontalAlignment: Int) =
    label(text, horizontalAlignment) {}
