package io.github.mslxl.ktswing.layout


import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import io.github.mslxl.ktswing.LayoutScope
import io.github.mslxl.ktswing.component.panel
import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.Component
import java.awt.Container
import javax.swing.JPanel

class CardLayoutLayerScope<T : Container>(self: T, val cardName: String) : ChildrenScope<T>(self) {
    override fun add(component: Component) {
        self.add(component, cardName)
    }
}

class CardLayoutScope<T : Container>(val self: T, val layout: CardLayout) : LayoutScope {
    init {
        self.layout = layout
    }

    inline fun card(name: String, block: CardLayoutLayerScope<T>.() -> Unit) {
        CardLayoutLayerScope(self, name).apply(block)
    }

    inline fun cardPanel(name: String, block: ContainerScope<JPanel>.() -> Unit) {
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

inline fun <T : Container> ContainerScope<T>.cardLayout(
    block: CardLayoutScope<T>.() -> Unit
): CardLayout {
    return cardLayout<T>().invoke(self).apply(block).layout
}
