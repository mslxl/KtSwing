@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import java.awt.CardLayout
import javax.swing.JComponent
import javax.swing.JPanel

// CardLayout
class _CardLayout : BasePanel(), SwingPanelNode {
    override fun _onAddToContent(comp: JComponent){
        add(comp)
    }

    init {
        layout = CardLayout()
    }
}

inline fun SwingPanelNode.cardpanel(init: _CardLayout.() -> Unit): JPanel = _ktswing(_CardLayout(), this, init)