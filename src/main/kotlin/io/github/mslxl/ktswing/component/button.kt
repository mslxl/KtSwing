
@file:Suppress("unused")
package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.Icon
import javax.swing.JButton

inline fun ChildrenScope<*>.button(text: String, block: BasicScope<JButton>.() -> Unit) =
    applyComponent(JButton(text), block)

inline fun ChildrenScope<*>.button(icon: Icon, block: BasicScope<JButton>.() -> Unit) =
    applyComponent(JButton(icon), block)

inline fun ChildrenScope<*>.button(text: String, icon: Icon, block: BasicScope<JButton>.() -> Unit) =
    applyComponent(JButton(text, icon), block)

fun ChildrenScope<*>.button(text: String) =
    button(text) {}

fun ChildrenScope<*>.button(icon: Icon) =
    button(icon) {}

fun ChildrenScope<*>.button(text: String, icon: Icon) =
    button(text, icon) {}
