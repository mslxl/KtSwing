@file:Suppress("unused")

package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.CanSetLayoutScope
import io.github.mslxl.ktswing.LayoutScope
import io.github.mslxl.ktswing.NeedUpdate
import io.github.mslxl.ktswing.layout.LayoutScopeWrapper
import java.awt.Container
import javax.swing.JPanel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> CanAddChildrenScope<T>.panel(block: CanSetLayoutScope<JPanel>.() -> Unit): JPanel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyContainer(JPanel(), block)
}


fun <T : Container> CanAddChildrenScope<T>.panel(): JPanel {
    return panel {

    }
}


@OptIn(ExperimentalContracts::class)
inline fun <T : Container, L : LayoutScope> CanAddChildrenScope<T>.panelWith(
    layoutScope: LayoutScopeWrapper<Container, L>,
    block: L.() -> Unit
): JPanel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return panel {
        val scope = layoutScope.invoke(self).apply(block)
        if (scope is NeedUpdate) scope.update()
    }
}