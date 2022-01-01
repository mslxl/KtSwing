package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.ComboBoxModel
import javax.swing.JComboBox
import javax.swing.JList
import javax.swing.ListModel


inline fun <T> ChildrenScope<*>.comboBox(block: BasicScope<JComboBox<T>>.() -> Unit) =
    applyComponent(JComboBox<T>(), block)

inline fun <T> ChildrenScope<*>.comboBox(model: ComboBoxModel<T>, block: BasicScope<JComboBox<T>>.() -> Unit) =
    applyComponent(JComboBox(model), block)

inline fun <reified T> ChildrenScope<*>.comboBox(data: List<T>, block: BasicScope<JComboBox<T>>.() -> Unit) =
    applyComponent(JComboBox<T>(data.toTypedArray()), block)

fun <T> ChildrenScope<*>.comboBox() = comboBox<T> { }
fun <T> ChildrenScope<*>.comboBox(model: ComboBoxModel<T>) = comboBox(model) {}
inline fun <reified T> ChildrenScope<*>.comboBox(data: List<T>) = comboBox(data) {}
