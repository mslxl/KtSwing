@file:Suppress("unused")

package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.JLabel

inline fun ChildrenScope<*>.label(text: String, block: BasicScope<JLabel>.() -> Unit) =
    applyComponent(JLabel(text), block)

fun ChildrenScope<*>.label(text: String) =
    label(text) {}


fun ChildrenScope<*>.label(text: String, horizontalAlignment: Int, block: BasicScope<JLabel>.() -> Unit) =
    applyComponent(JLabel(text, horizontalAlignment), block)

fun ChildrenScope<*>.label(text: String, horizontalAlignment: Int) =
    label(text, horizontalAlignment) {}
