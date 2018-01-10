@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.control.ToolBar

class _ToolBar: ToolBar(),FxPanelNode {
    override fun _onAddToContent(comp: Node) {
        items.add(comp)
    }
}

inline fun FxPanelNodePanel.toolBar(block: _ToolBar.() -> Unit) = _ktfx(_ToolBar(), block)