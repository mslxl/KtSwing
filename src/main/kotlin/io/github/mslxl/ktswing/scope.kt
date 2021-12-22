@file:Suppress("unused")
package io.github.mslxl.ktswing

import java.awt.Component
import java.awt.Container
import java.awt.Frame

@KtSwingMarker
interface EmptyScope

interface LayoutScope : EmptyScope

interface NeedUpdate {
    fun update()
}

open class BasicScope<T : Component>(val self: T) : EmptyScope {
    inline fun attr(block: T.() -> Unit) = self.apply(block)
    inline fun prop(block: T.() -> Unit) = attr(block)
}


open class ContainerScope<T : Container>(self: T) : BasicScope<T>(self) {
    inline fun defaultLayout(block: ChildrenScope<T>.() -> Unit) {
        ChildrenScope(self).apply(block)
    }

}

open class ChildrenScope<T : Container>(self: T) : ContainerScope<T>(self) {
    open fun add(component: Component) {
        self.add(component)
    }
}

class FrameScope<T : Frame>(self: T) : ContainerScope<T>(self)