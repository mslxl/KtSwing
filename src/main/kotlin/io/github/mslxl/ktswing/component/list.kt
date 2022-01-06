package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.JList
import javax.swing.ListModel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T> CanAddChildrenScope<*>.list(block: BasicScope<JList<T>>.() -> Unit): JList<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JList<T>(), block)
}


@OptIn(ExperimentalContracts::class)
inline fun <T> CanAddChildrenScope<*>.list(model: ListModel<T>, block: BasicScope<JList<T>>.() -> Unit): JList<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JList<T>(model), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T> CanAddChildrenScope<*>.list(data: List<T>, block: BasicScope<JList<T>>.() -> Unit): JList<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JList<T>(data.toTypedArray()), block)
}

fun <T> CanAddChildrenScope<*>.list() = list<T> { }
fun <T> CanAddChildrenScope<*>.list(model: ListModel<T>) = list(model) {}
inline fun <reified T> CanAddChildrenScope<*>.list(data: List<T>) = list(data) {}
