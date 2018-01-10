@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import javax.swing.JComponent
import javax.swing.JPanel


class _AabsoluteLayout : BasePanel(), SwingPanelNode {
    override fun _onAddToContent(comp: JComponent) {
        this.add(comp)
    }
    init {
        layout = null
    }
}

inline fun SwingPanelNode.absolutepanel(init: _AabsoluteLayout.() -> Unit): JPanel = _ktswing(_AabsoluteLayout(), this, init)


