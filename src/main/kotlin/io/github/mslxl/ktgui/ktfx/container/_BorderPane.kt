@file:JvmName("Container")
@file:JvmMultifileClass


package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._createFxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.layout.BorderPane

class _BorderPane:BorderPane(){


    fun top(block:FxPanelNode.()->Unit){
        _createFxPanelNode {
            top = it
        }.apply(block)
    }
    fun bottom(block:FxPanelNode.()->Unit){
        _createFxPanelNode {
            bottom = it
        }.apply(block)
    }
    inline fun left(block:FxPanelNode.()->Unit){
        _createFxPanelNode {
            left = it
        }.apply(block)
    }
    fun right(block:FxPanelNode.()->Unit){
        _createFxPanelNode {
            right = it
        }.apply(block)
    }
    fun center(block:FxPanelNode.()->Unit){
        _createFxPanelNode {
            center = it
        }.apply(block)
    }
}

inline fun FxPanelNodePanel.borderPane(init:_BorderPane.()->Unit) = _ktfx(_BorderPane(),init)