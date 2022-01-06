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

interface BasicScope<T : Component> : EmptyScope {
    companion object {
        operator fun <T : Component> invoke(self: T) = object : BasicScope<T> {
            override val self: T = self
        }
    }

    val self: T
}

inline fun <T : Component> BasicScope<T>.prop(block: T.() -> Unit) = attr(block)

inline fun <T : Component> BasicScope<T>.attr(block: T.() -> Unit) = self.apply(block)


interface CanSetLayoutScope<T : Container> : BasicScope<T> {
    companion object {
        operator fun <T : Container> invoke(self: T) = object : CanSetLayoutScope<T> {
            override val self: T = self
        }
    }
}

inline fun <T : Container> CanSetLayoutScope<T>.defaultLayout(block: CanAddChildrenScope<T>.() -> Unit) {
    CanAddChildrenScope(self).apply(block)
}


interface CanAddChildrenScope<T : Container> : BasicScope<T> {
    companion object {
        operator fun <T : Container> invoke(self: T) = object : CanAddChildrenScope<T> {
            override val self: T = self
        }
    }

    fun add(component: Component) {
        self.add(component)
    }
}

class FrameScope<T : Frame>(override val self: T) : CanSetLayoutScope<T>