@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.common.err
import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar

class _ButtonBar:ButtonBar(),FxPanelNode{
    override fun _onAddToContent(comp: Node) {
        if (comp is Button){
            buttons.add(comp)
        } else {
            err("Can not add ${comp::class.java.name} to ${ButtonBar::class.java.name}")
        }

    }
}

inline fun FxPanelNodePanel.buttonBar(block:_ButtonBar.()->Unit) = _ktfx(_ButtonBar(),block)