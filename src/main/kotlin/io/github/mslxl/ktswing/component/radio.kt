package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.ButtonGroup
import javax.swing.Icon
import javax.swing.JCheckBox
import javax.swing.JRadioButton

inline fun ChildrenScope<*>.radioButton(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButton>.() -> Unit
): JRadioButton {
    val btn = JRadioButton(text, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

inline fun ChildrenScope<*>.radioButton(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButton>.() -> Unit
): JRadioButton {
    val btn = JRadioButton(icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

inline fun ChildrenScope<*>.radioButton(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButton>.() -> Unit
): JRadioButton {
    val btn = JRadioButton(text, icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

fun ChildrenScope<*>.radioButton(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null
) =
    radioButton(text, selected, group) {}

fun ChildrenScope<*>.radioButton(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) =
    radioButton(icon, selected, group) {}

fun ChildrenScope<*>.radioButton(
    text: String, icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) =
    radioButton(text, icon, selected, group) {}
