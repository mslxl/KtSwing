package io.github.mslxl.ktgui.ktfx

import io.github.mslxl.ktgui.common.KtDSL
import io.github.mslxl.ktgui.common.PanelNode
import javafx.event.EventTarget
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@KtDSL
interface FxPanelNode: FxPanelNodePanel
@KtDSL
interface FxPanelNodePanel: PanelNode<Node>

inline fun <T:Node> FxPanelNodePanel._ktfx(comp:T,init:T.()->Unit):T{
    _ktfxInit(comp)
    init.invoke(comp)
    this._onAddToContent(comp)
    return comp
}

fun _ktfxInit(comp: EventTarget){

}

inline fun _createFxPanelNode(crossinline block:(Node) -> Unit) = object :FxPanelNode{
    override fun _onAddToContent(comp: Node) {
        block.invoke(comp)
    }
}

inline fun _createFxPanelNodePanel(crossinline block:(Parent) -> Unit) = object :FxPanelNodePanel{
    override fun _onAddToContent(comp: Node) {
        block.invoke(comp as Parent)
    }
}

@KtDSL
inline fun Scene(block:FxPanelNodePanel.()->Unit):Scene{
    var scene:Scene?=null
    _createFxPanelNodePanel {
        scene= Scene(it)
    }.apply(block)
    return scene?: Scene(Group())
}