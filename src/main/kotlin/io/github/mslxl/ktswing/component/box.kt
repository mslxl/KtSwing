package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.CanAddChildrenScope
import java.awt.Component
import java.awt.Dimension
import javax.swing.Box

class BoxScope(override val self: Box, private val isVertical: Boolean) : CanAddChildrenScope<Box> {

    @Suppress("NOTHING_TO_INLINE")
    private inline fun <T : Component> addAndReturn(comp: T): T {
        add(comp)
        return comp
    }

    /**
     * Create vertical glue or horizontal glue
     */
    val glue: Component
        get() = addAndReturn(
            if (isVertical) Box.createVerticalGlue()
            else Box.createHorizontalBox()
        )


    /**
     * Create a glue
     */
    val glueAround: Component
        get() = addAndReturn(
            Box.createGlue()
        )

    fun struct(size: Int): Component = addAndReturn(
        if (isVertical) Box.createVerticalStrut(size)
        else Box.createHorizontalStrut(size)
    )

    fun rigidArea(width: Int, height: Int) = addAndReturn(
        Box.createRigidArea(Dimension(width, height))
    )

}

inline fun CanAddChildrenScope<*>.vBox(block: BoxScope.() -> Unit): Box {
    val box = Box.createVerticalBox()
    BoxScope(box, true).apply(block)
    add(box)
    return box
}

inline fun CanAddChildrenScope<*>.hBox(block: BoxScope.() -> Unit): Box {
    val box = Box.createHorizontalBox()
    BoxScope(box, false).apply(block)
    add(box)
    return box
}
