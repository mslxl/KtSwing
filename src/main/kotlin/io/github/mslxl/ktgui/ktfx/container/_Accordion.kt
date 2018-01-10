@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

class _Accordion: Accordion(){

    inline fun pane(title: String="",init: _TitledPane.() -> Unit):TitledPane{
        return _TitledPane().apply {
            text = title
        }.also(init).also {
            panes.add(it)
        }
    }
}

class _TitledPane:TitledPane(),FxPanelNode{
    override fun _onAddToContent(comp: Node) {
        content = comp
    }
}

inline fun FxPanelNodePanel.accordion(init:_Accordion.()->Unit) = _ktfx(_Accordion(),init)