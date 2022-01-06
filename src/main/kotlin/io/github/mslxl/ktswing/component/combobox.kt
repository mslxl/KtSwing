package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.ComboBoxModel
import javax.swing.JComboBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


@OptIn(ExperimentalContracts::class)
inline fun <T> CanAddChildrenScope<*>.comboBox(block: BasicScope<JComboBox<T>>.() -> Unit): JComboBox<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JComboBox<T>(), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <T> CanAddChildrenScope<*>.comboBox(
    model: ComboBoxModel<T>,
    block: BasicScope<JComboBox<T>>.() -> Unit
): JComboBox<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JComboBox(model), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T> CanAddChildrenScope<*>.comboBox(
    data: List<T>,
    block: BasicScope<JComboBox<T>>.() -> Unit
): JComboBox<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JComboBox<T>(data.toTypedArray()), block)
}

fun <T> CanAddChildrenScope<*>.comboBox() = comboBox<T> { }
fun <T> CanAddChildrenScope<*>.comboBox(model: ComboBoxModel<T>) = comboBox(model) {}
inline fun <reified T> CanAddChildrenScope<*>.comboBox(data: List<T>) = comboBox(data) {}
