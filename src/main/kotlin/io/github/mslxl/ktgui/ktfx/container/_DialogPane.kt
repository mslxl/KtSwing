@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._createFxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.control.DialogPane

class _DialogPane:DialogPane(){
    fun header(block: FxPanelNode.() -> Unit){
        _createFxPanelNode {
            header = it
        }.apply(block)
    }
    fun graphic(block: FxPanelNode.() -> Unit){
        _createFxPanelNode {
            graphic = it
        }.apply(block)
    }
    fun content(block: FxPanelNode.() -> Unit){
        _createFxPanelNode {
            content = it
        }.apply(block)
    }
    fun expandableContent(block: FxPanelNode.() -> Unit){
        _createFxPanelNode {
            expandableContent = it
        }.apply(block)
    }
}
inline fun FxPanelNodePanel.dialogPane(block:_DialogPane.()->Unit) = _ktfx(_DialogPane(),block)