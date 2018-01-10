@file:JvmName("Container")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.container

import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.layout.GridPane

class _GridPane: GridPane() {
    init {
        TODO("我还没想好怎么设计\n待续")
    }
}

inline fun FxPanelNodePanel.gridPane(block:_GridPane.()->Unit) = _ktfx(_GridPane(),block)