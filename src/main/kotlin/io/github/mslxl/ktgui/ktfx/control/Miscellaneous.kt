package io.github.mslxl.ktgui.ktfx.control

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import io.github.mslxl.ktgui.ktfx._ktfxInit
import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.control.Control
import javafx.scene.control.Tooltip
import javafx.scene.layout.Region

inline fun FxPanelNode.canvas(block: Canvas.() -> Unit) = _ktfx(Canvas(), block)

inline fun FxPanelNode.group(block: Group.() -> Unit) = _ktfx(Group(), block)

inline fun FxPanelNode.region(block: Region.() -> Unit) = _ktfx(Region(), block)

inline fun Control.tooltip(block: Tooltip.() -> Unit) = Tooltip().apply { _ktfxInit(this) }.apply(block).also { tooltip = it }

inline var Control.tooltip: String
    get() = tooltip.text
    set(value) {
        tooltip = Tooltip(value)
    }

// TODO
// inline fun FxPanelNode.region(block: SubScene.() -> Unit) = _ktfx(SubScene(),block)