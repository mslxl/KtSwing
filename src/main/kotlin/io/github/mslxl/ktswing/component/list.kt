package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import javax.swing.JList
import javax.swing.ListModel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T> ChildrenScope<*>.list(block: BasicScope<JList<T>>.() -> Unit): JList<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JList<T>(), block)
}


@OptIn(ExperimentalContracts::class)
inline fun <T> ChildrenScope<*>.list(model: ListModel<T>, block: BasicScope<JList<T>>.() -> Unit): JList<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JList<T>(model), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T> ChildrenScope<*>.list(data: List<T>, block: BasicScope<JList<T>>.() -> Unit): JList<T> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JList<T>(data.toTypedArray()), block)
}

fun <T> ChildrenScope<*>.list() = list<T> { }
fun <T> ChildrenScope<*>.list(model: ListModel<T>) = list(model) {}
inline fun <reified T> ChildrenScope<*>.list(data: List<T>) = list(data) {}
