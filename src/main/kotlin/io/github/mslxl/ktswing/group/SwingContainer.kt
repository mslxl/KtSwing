package io.github.mslxl.ktswing.group

import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.ContainerScope
import javafx.scene.Parent
import java.awt.Component
import java.awt.Container
import javax.swing.JComponent

private object EmptyJComponent : JComponent()


class SwingComponentBuilderScope<T>() : ChildrenScope<JComponent>(EmptyJComponent) {
    var component: T? = null
    override fun add(component: Component) {
        @Suppress("UNCHECKED_CAST")
        this.component = component as T
    }
}


inline fun <T> swing(block: SwingComponentBuilderScope<T>.() -> Unit): T =
    SwingComponentBuilderScope<T>().apply(block).component!!
