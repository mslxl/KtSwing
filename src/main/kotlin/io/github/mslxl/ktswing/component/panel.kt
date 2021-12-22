@file:Suppress("unused")
package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.LayoutScope
import io.github.mslxl.ktswing.NeedUpdate
import io.github.mslxl.ktswing.layout.LayoutScopeWrapper
import java.awt.Container
import javax.swing.JPanel

inline fun <T : Container> ChildrenScope<T>.panel(block: ContainerScope<JPanel>.() -> Unit) {
    applyContainer(JPanel(), block)
}

fun <T : Container> ChildrenScope<T>.panel() = panel {

}

inline fun <T : Container, L : LayoutScope> ChildrenScope<T>.panelWith(
    layoutScope: LayoutScopeWrapper<Container, L>,
    block: L.() -> Unit
) {
    panel {
        val scope = layoutScope.invoke(self).apply(block)
        if (scope is NeedUpdate) scope.update()
    }
}