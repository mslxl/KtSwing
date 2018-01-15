@file:JvmName("KtGUI")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.common

import io.github.mslxl.ktgui.ktfx.*
import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing.SwingUI
import io.github.mslxl.ktgui.ktswing._UIPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import javafx.embed.swing.JFXPanel
import javafx.embed.swing.SwingNode

@KtDSL
fun FxPanelNodePanel.swing(block: _UIPanelNode.() -> Unit): SwingNode {
    return _ktfx(SwingNode(), {
        awtThread {
            content = SwingUI(block).view
        }
    })
}

@KtDSL
fun SwingPanelNode.fx(block: FxPanelNode.() -> Unit) = _ktswing(JFXPanel(), {
    fxThread {
        scene = Scene{
            val s = this
            _createFxPanelNode {
                s._ktfx(it){}
            }.apply(block)
        }
    }
})

