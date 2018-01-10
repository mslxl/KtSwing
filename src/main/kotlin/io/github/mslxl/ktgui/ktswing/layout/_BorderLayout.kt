@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._createSwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import java.awt.BorderLayout
import javax.swing.JPanel

// BorderLayout
class _BorderLayout : BasePanel() {
    init {
        layout = BorderLayout()
    }

    fun north(init: SwingPanelNode.() -> Unit) {
        _createSwingPanelNode {
            this.add(it, java.awt.BorderLayout.NORTH)
        }.apply(init)
    }

    fun south(init: SwingPanelNode.() -> Unit) {
        _createSwingPanelNode {
            this.add(it, java.awt.BorderLayout.SOUTH)
        }.apply(init)
    }

    fun west(init: SwingPanelNode.() -> Unit) {
        _createSwingPanelNode {
            this.add(it, java.awt.BorderLayout.WEST)
        }.apply(init)
    }

    fun east(init: SwingPanelNode.() -> Unit) {
        _createSwingPanelNode {
            this.add(it, java.awt.BorderLayout.EAST)
        }.apply(init)
    }

    fun centre(init: SwingPanelNode.() -> Unit) {
        _createSwingPanelNode {
            this.add(it, java.awt.BorderLayout.CENTER)
        }.apply(init)
    }
}

inline fun SwingPanelNode.borderpanel(init: _BorderLayout.() -> Unit): JPanel = _ktswing(_BorderLayout(), this, init)