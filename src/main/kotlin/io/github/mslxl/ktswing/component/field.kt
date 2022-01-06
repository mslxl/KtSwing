@file:Suppress("unused")

package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.JPasswordField
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.text.Document
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.textField(
    doc: Document? = null,
    text: String? = null,
    column: Int = 0,
    block: BasicScope<JTextField>.() -> Unit
): JTextField {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyContainer(JTextField(doc, text, column), block)
}

fun CanAddChildrenScope<*>.textField(
    doc: Document? = null,
    text: String? = null,
    column: Int = 0,
) = textField(doc, text, column) {}


@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.passwordField(
    doc: Document? = null,
    password: String? = null,
    column: Int = 0,
    block: BasicScope<JPasswordField>.() -> Unit
): JPasswordField {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JPasswordField(doc, password, column), block)
}

fun CanAddChildrenScope<*>.passwordField(
    doc: Document? = null,
    password: String? = null,
    column: Int = 0,
) = passwordField(doc, password, column) {}

@OptIn(ExperimentalContracts::class)
fun CanAddChildrenScope<*>.textArea(
    doc: Document? = null,
    text: String? = null,
    row: Int = 0,
    column: Int = 0,
    block: BasicScope<JTextArea>.() -> Unit
): JTextArea {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JTextArea(doc, text, row, column), block)
}

fun CanAddChildrenScope<*>.textArea(
    doc: Document? = null,
    text: String? = null,
    row: Int = 0,
    column: Int = 0,
) = textArea(doc, text, row, column) {}

