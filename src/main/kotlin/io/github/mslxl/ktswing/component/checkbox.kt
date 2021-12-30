package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.Icon
import javax.swing.JCheckBox

inline fun ChildrenScope<*>.checkBox(text: String, selected: Boolean = false, block: BasicScope<JCheckBox>.() -> Unit) =
    applyComponent(JCheckBox(text, selected), block)

inline fun ChildrenScope<*>.checkBox(icon: Icon, selected: Boolean = false, block: BasicScope<JCheckBox>.() -> Unit) =
    applyComponent(JCheckBox(icon, selected), block)

inline fun ChildrenScope<*>.checkBox(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JCheckBox>.() -> Unit
) =
    applyComponent(JCheckBox(text, icon, selected), block)

fun ChildrenScope<*>.checkBox(text: String) =
    checkBox(text) {}

fun ChildrenScope<*>.checkBox(icon: Icon) =
    checkBox(icon) {}

fun ChildrenScope<*>.checkBox(text: String, icon: Icon) =
    checkBox(text, icon) {}
