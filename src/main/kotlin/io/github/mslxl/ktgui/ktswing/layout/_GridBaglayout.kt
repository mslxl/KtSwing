@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._createSwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JPanel

// GridBagLayout
class _GridBaglayout() : BasePanel() {
    init {
        layout = GridBagLayout()
    }

    //  int anchor, int fill, Insets insets, int ipadx, int ipady
    inline fun constraints(gridX: Int = GridBagConstraints.RELATIVE,
                           gridY: Int = GridBagConstraints.RELATIVE,
                           gridWidth: Int = 1,
                           gridHeight: Int = 1,
                           weightX: Double = 0.0,
                           weightY: Double = 0.0,
                           anchor: Int = GridBagConstraints.CENTER,
                           fill: Int = GridBagConstraints.NONE,
                           insets: Insets = Insets(0, 0, 0, 0),
                           ipadX: Int = 0,
                           ipadY: Int = 0,
                           init: SwingPanelNode.() -> Unit) {
        _createSwingPanelNode { this.add(it, java.awt.GridBagConstraints(gridX, gridY, gridWidth, gridHeight, weightX, weightY, anchor, fill, insets, ipadX, ipadY)) }.apply(init)
    }
}

inline fun SwingPanelNode.gridbagpanel(init: _GridBaglayout.() -> Unit): JPanel = _ktswing(_GridBaglayout(), this, init)