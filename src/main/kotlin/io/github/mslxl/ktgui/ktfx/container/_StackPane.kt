@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.layout.StackPane

class _StackPane:StackPane(),FxPanelNode {
    override fun _onAddToContent(comp: Node) {
        children.add(comp)
    }
}

inline fun FxPanelNode.stackPane(block:_StackPane.()->Unit) = _ktfx(_StackPane(),block)