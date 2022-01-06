package io.github.mslxl.ktswing.layout


import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.CanSetLayoutScope
import io.github.mslxl.ktswing.LayoutScope
import io.github.mslxl.ktswing.component.panel
import java.awt.CardLayout
import java.awt.Component
import java.awt.Container
import javax.swing.JPanel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class CardLayoutLayerScope<T : Container>(override val self: T, val cardName: String) : CanAddChildrenScope<T> {
    override fun add(component: Component) {
        self.add(component, cardName)
    }
}

class CardLayoutScope<T : Container>(val self: T, val layout: CardLayout) : LayoutScope {
    init {
        self.layout = layout
    }

    @OptIn(ExperimentalContracts::class)
    inline fun card(name: String, block: CardLayoutLayerScope<T>.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        CardLayoutLayerScope(self, name).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun cardPanel(name: String, block: CanSetLayoutScope<JPanel>.() -> Unit) {
        contract {
            callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
        }
        card(name) {
            panel(block)
        }
    }

    fun show(name: String) {
        layout.show(self, name)
    }
}


fun <T : Container> cardLayout(
): LayoutScopeWrapper<T, CardLayoutScope<T>> {
    val layout = CardLayout()
    return { it: T -> CardLayoutScope(it, layout) }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Container> CanSetLayoutScope<T>.cardLayout(
    block: CardLayoutScope<T>.() -> Unit
): CardLayout {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
    return cardLayout<T>().invoke(self).apply(block).layout
}
