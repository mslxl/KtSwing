@file:Suppress("unused")

package io.github.mslxl.ktswing.layout


import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.LayoutScope
import io.github.mslxl.ktswing.NeedUpdate
import java.awt.Component
import java.awt.Container
import java.awt.GridLayout
import javax.swing.JLabel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.math.max

class GridLayoutRootScope<T : Container>(val self: T, val layout: GridLayout) : LayoutScope, NeedUpdate {
    init {
        self.layout = layout
    }

    val rows = arrayListOf<GridLayoutRowScope<T>>()

    @OptIn(ExperimentalContracts::class)
    inline fun row(block: GridLayoutRowScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        layout.rows++
        val row = GridLayoutRowScope(self, layout, layout.rows).apply(block)
        rows.add(row)
    }

    override fun update() {
        self.removeAll()
        layout.rows = rows.size
        layout.columns = rows.fold(0) { maxCol: Int, rowScope: GridLayoutRowScope<T> ->
            max(maxCol, rowScope.column.size)
        }
        rows.forEach { r ->
            r.column.forEach(self::add)
            for (idx in r.column.size until layout.columns) {
                self.add(JLabel())
            }
        }
        self.addNotify()
    }
}

class GridLayoutRowScope<T : Container>(self: T, val layout: GridLayout, val rowPos: Int) :
    ChildrenScope<T>(self) {
    internal val column = arrayListOf<Component>()
    override fun add(component: Component) {
        column.add(component)
    }
}

fun <T : Container> gridLayout(
    hGap: Int = 0,
    vGap: Int = 0,
): LayoutScopeWrapper<T, GridLayoutRootScope<T>> {
    val layout = GridLayout(0, 1, hGap, vGap)
    return { it: T -> GridLayoutRootScope(it, layout) }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> ContainerScope<T>.gridLayout(
    hGap: Int = 0,
    vGap: Int = 0,
    block: GridLayoutRootScope<T>.() -> Unit
): GridLayout {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    return gridLayout<T>(hGap, vGap).invoke(self).apply(block).apply {
        update()
    }.layout
}
