@file:JvmName("Container")
@file:JvmMultifileClass
package io.github.mslxl.ktgui.ktfx.container


import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

class _TabPane : TabPane(){
    inline fun tab(title:String="",block:Tab.()->Unit){
        _Tab(title).apply(block).let {
            tabs.add(it)
        }
    }
    class _Tab(text: String): Tab(text),FxPanelNode{
        override fun _onAddToContent(comp: Node) {
            content = comp
        }
    }
}

inline fun FxPanelNode.tabPane(block:_TabPane.()->Unit) = _ktfx(_TabPane(),block)
