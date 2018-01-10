@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.layout.HBox

class _HBox : HBox(), FxPanelNode {
    override fun _onAddToContent(comp: Node) {
        children.add(comp)
    }
}

inline fun FxPanelNodePanel.hBox(block: _HBox.() -> Unit) = _ktfx(_HBox(), block)