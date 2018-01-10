@file:JvmName("KtGUI")

package io.github.mslxl.ktgui.common

import io.github.mslxl.ktgui.ktfx.*
import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing.UI
import io.github.mslxl.ktgui.ktswing._UIPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.embed.swing.SwingNode

@KtDSL
fun FxPanelNodePanel.swing(block: _UIPanelNode.() -> Unit): SwingNode {
    return _ktfx(SwingNode(), {
        uiThreadAsync {
            content = UI(block).view
        }
    })
}

@KtDSL
fun SwingPanelNode.fx(block: FxPanelNode.() -> Unit) = _ktswing(JFXPanel(), this, {
    Platform.runLater {
        scene = Scene{
            val s = this
            _createFxPanelNode {
                s._ktfx(it){}
            }.apply(block)
        }
    }
})

