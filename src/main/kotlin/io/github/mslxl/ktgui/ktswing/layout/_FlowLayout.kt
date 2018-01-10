@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import java.awt.FlowLayout
import javax.swing.JComponent
import javax.swing.JPanel

// FlowLayout
class _FlowLayout : BasePanel(), SwingPanelNode {
    override fun _onAddToContent(comp: JComponent) {
        add(comp)
    }

    init {
        layout = FlowLayout()
    }
}

inline fun SwingPanelNode.flowpanel(init: _FlowLayout.() -> Unit): JPanel = _ktswing(_FlowLayout(), this, init)
