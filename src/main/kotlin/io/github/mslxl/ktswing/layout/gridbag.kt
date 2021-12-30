package io.github.mslxl.ktswing.layout

import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.LayoutScope
import java.awt.Component
import java.awt.Container
import java.awt.GridBagConstraints
import java.awt.GridBagLayout

class GridBagLayoutRootScope<T : Container>(val self: T, val layout: GridBagLayout) : LayoutScope {
    init {
        self.layout = layout
    }

    inline fun cell(block: GridBagLayoutCellScope<T>.() -> Unit) {
        GridBagLayoutCellScope(self, layout).apply(block)
    }
}

class GridBagLayoutCellScope<T : Container>(self: T, val layout: GridBagLayout) :
    ChildrenScope<T>(self) {
    val constraints = GridBagConstraints()
    inline fun cons(block: GridBagConstraints.() -> Unit) {
        constraints.apply(block)
    }

    override fun add(component: Component) {
        layout.setConstraints(component, constraints)
        self.add(component)
    }
}

fun <T : Container> gridBagLayout(
): LayoutScopeWrapper<T, GridBagLayoutRootScope<T>> {
    val layout = GridBagLayout()
    return { it: T -> GridBagLayoutRootScope(it, layout) }
}

inline fun <T : Container> ContainerScope<T>.gridBagLayout(
    block: GridBagLayoutRootScope<T>.() -> Unit
): GridBagLayout {
    return gridBagLayout<T>().invoke(self).apply(block).layout
}
