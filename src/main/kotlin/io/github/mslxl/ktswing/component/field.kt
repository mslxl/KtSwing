@file:Suppress("unused")
package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.JPasswordField
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.text.Document

inline fun ChildrenScope<*>.textField(
    doc: Document? = null,
    text: String? = null,
    column: Int = 0,
    block: BasicScope<JTextField>.() -> Unit
) = applyContainer(JTextField(doc, text, column), block)

fun ChildrenScope<*>.textField(
    doc: Document? = null,
    text: String? = null,
    column: Int = 0,
) = textField(doc, text, column) {}


inline fun ChildrenScope<*>.passwordField(
    doc: Document? = null,
    password: String? = null,
    column: Int = 0,
    block: BasicScope<JPasswordField>.() -> Unit
) = applyComponent(JPasswordField(doc, password, column), block)

fun ChildrenScope<*>.passwordField(
    doc: Document? = null,
    password: String? = null,
    column: Int = 0,
) = passwordField(doc, password, column) {}

fun ChildrenScope<*>.textArea(
    doc: Document? = null,
    text: String? = null,
    row: Int = 0,
    column: Int = 0,
    block: BasicScope<JTextArea>.() -> Unit
) = applyComponent(JTextArea(doc, text, row, column), block)

fun ChildrenScope<*>.textArea(
    doc: Document? = null,
    text: String? = null,
    row: Int = 0,
    column: Int = 0,
) = textArea(doc, text, row, column) {}

