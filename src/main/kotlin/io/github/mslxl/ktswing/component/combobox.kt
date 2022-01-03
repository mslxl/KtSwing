package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.ComboBoxModel
import javax.swing.JComboBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


@OptIn(ExperimentalContracts::class)
inline fun <T> ChildrenScope<*>.comboBox(block: BasicScope<JComboBox<T>>.() -> Unit): JComboBox<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JComboBox<T>(), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <T> ChildrenScope<*>.comboBox(
    model: ComboBoxModel<T>,
    block: BasicScope<JComboBox<T>>.() -> Unit
): JComboBox<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JComboBox(model), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T> ChildrenScope<*>.comboBox(
    data: List<T>,
    block: BasicScope<JComboBox<T>>.() -> Unit
): JComboBox<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JComboBox<T>(data.toTypedArray()), block)
}

fun <T> ChildrenScope<*>.comboBox() = comboBox<T> { }
fun <T> ChildrenScope<*>.comboBox(model: ComboBoxModel<T>) = comboBox(model) {}
inline fun <reified T> ChildrenScope<*>.comboBox(data: List<T>) = comboBox(data) {}
