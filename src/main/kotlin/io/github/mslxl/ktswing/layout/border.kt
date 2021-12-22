package io.github.mslxl.ktswing.layout

import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.LayoutScope
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Container

class BorderLayoutDirectionScope<T : Container>(self: T, val direction: String) : ChildrenScope<T>(self) {
    override fun add(component: Component) {
        self.add(component, direction)
    }
}

class BorderLayoutScope<T : Container>(val self: T, val layout: BorderLayout) : LayoutScope {
    init {
        self.layout = layout
    }

    inline fun left(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        BorderLayoutDirectionScope(self, BorderLayout.WEST).apply(block)
    }

    inline fun right(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        BorderLayoutDirectionScope(self, BorderLayout.EAST).apply(block)
    }

    inline fun top(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        BorderLayoutDirectionScope(self, BorderLayout.NORTH).apply(block)
    }

    inline fun bottom(block: BorderLayoutDirectionScope<T>.() -> Unit) {
        BorderLayoutDirectionScope(self, BorderLayout.SOUTH).apply(block)
    }

    inline fun center(block: BorderLayoutDirectionScope<T>.() -> Unit) {
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

inline fun <T : Container> ContainerScope<T>.borderLayout(
    hGap: Int = 0,
    vGap: Int = 0,
    block: BorderLayoutScope<T>.() -> Unit
): BorderLayout {
    return borderLayout<T>(hGap, vGap).invoke(self).apply(block).layout
}