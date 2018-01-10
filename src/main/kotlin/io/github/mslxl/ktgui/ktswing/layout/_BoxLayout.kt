@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import javax.swing.BoxLayout
import javax.swing.JComponent
import javax.swing.JPanel

// BoxLayout
class _BoxLayout(axis: AXIS) : BasePanel(), SwingPanelNode {
    override fun _onAddToContent(comp: JComponent) {
        add(comp)
    }

    init {
        layout = BoxLayout(this, when (axis) {
            AXIS.X_AXIS -> 0
            AXIS.Y_AXIS -> 1
            AXIS.LINE_AXIS -> 2
            AXIS.PAGE_AXIS -> 3
        })
    }
}

enum class AXIS {
    X_AXIS, Y_AXIS, LINE_AXIS, PAGE_AXIS
}

inline fun SwingPanelNode.boxpanel(axis: AXIS = AXIS.X_AXIS, init: _BoxLayout.() -> Unit): JPanel = _ktswing(_BoxLayout(axis), this, init)