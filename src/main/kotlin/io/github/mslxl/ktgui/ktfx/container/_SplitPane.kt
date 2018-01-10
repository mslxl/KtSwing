@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.control.SplitPane

class _SplitPane: SplitPane(),FxPanelNode {
    override fun _onAddToContent(comp: Node) {
        items.add(comp)
    }
}

inline fun FxPanelNode.splitPane(block:_SplitPane.()->Unit) = _ktfx(_SplitPane(),block)