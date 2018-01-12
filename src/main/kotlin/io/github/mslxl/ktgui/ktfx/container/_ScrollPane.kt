@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.control.ScrollPane

class _ScrollPane:ScrollPane(),FxPanelNode{
    override fun _onAddToContent(comp: Node) {
        content = comp
    }
}

inline fun FxPanelNodePanel.scrollPane(block:_ScrollPane.()->Unit) = _ktfx(_ScrollPane(),block)