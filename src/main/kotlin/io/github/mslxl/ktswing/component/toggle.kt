package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.Icon
import javax.swing.JCheckBox
import javax.swing.JToggleButton

inline fun ChildrenScope<*>.toggleButton(
    text: String,
    selected: Boolean = false,
    block: BasicScope<JToggleButton>.() -> Unit
) =
    applyComponent(JToggleButton(text, selected), block)

inline fun ChildrenScope<*>.toggleButton(
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JToggleButton>.() -> Unit
) =
    applyComponent(JToggleButton(icon, selected), block)

inline fun ChildrenScope<*>.toggleButton(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JToggleButton>.() -> Unit
) =
    applyComponent(JToggleButton(text, icon, selected), block)

fun ChildrenScope<*>.toggleButton(text: String) =
    toggleButton(text) {}

fun ChildrenScope<*>.toggleButton(icon: Icon) =
    toggleButton(icon) {}

fun ChildrenScope<*>.toggleButton(text: String, icon: Icon) =
    toggleButton(text, icon) {}
