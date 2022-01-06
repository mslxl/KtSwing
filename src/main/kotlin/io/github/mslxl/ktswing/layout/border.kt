package io.github.mslxl.ktswing.layout

import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.CanSetLayoutScope
import io.github.mslxl.ktswing.LayoutScope
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Container
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class BorderLayoutDirectionScope<T : Container>(override val self: T, val direction: String) : CanAddChildrenScope<T> {
    override fun add(component: Component) {
        self.add(component, direction)
    }
}

class BorderLayoutScope<T : Container>(val self: T, val layout: BorderLayout) : LayoutScope {
    init {
        self.layout = layout
    }

    @OptIn(ExperimentalContracts::class)
    inline fun left(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
        }
        BorderLayoutDirectionScope(self, BorderLayout.WEST).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun right(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
        }
        BorderLayoutDirectionScope(self, BorderLayout.EAST).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun top(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
        }
        BorderLayoutDirectionScope(self, BorderLayout.NORTH).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun bottom(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
        }
        BorderLayoutDirectionScope(self, BorderLayout.SOUTH).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun center(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
        }
        BorderLayoutDirectionScope(self, BorderLayout.CENTER).apply(block)
    }
}


fun <T : Container> borderLayout(
    hGap: Int = 0,
    vGap: Int = 0,
): LayoutScopeWrapper<T, BorderLayoutScope<T>> {
    val layout = BorderLayout(hGap, vGap)
    return { it: T -> BorderLayoutScope(it, layout) }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> CanSetLayoutScope<T>.borderLayout(
    hGap: Int = 0,
    vGap: Int = 0,
    block: BorderLayoutScope<T>.() -> Unit
): BorderLayout {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    return borderLayout<T>(hGap, vGap).invoke(self).apply(block).layout
}