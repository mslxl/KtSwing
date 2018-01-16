@file:JvmName("JFoenix")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.jfoenix

import com.jfoenix.controls.*
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import io.github.mslxl.ktgui.ktfx.*
import javafx.scene.Group

inline fun <T> FxPanelNode.jfxListView(block: JFXListView<T>.() -> Unit = {}) = _ktfx(JFXListView(), block)

inline fun FxPanelNode.jfxDatePicker(block: JFXDatePicker.() -> Unit = {}) = _ktfx(JFXDatePicker(), block)

inline fun FxPanelNode.jfxDialog(block: JFXDialog.() -> Unit = {}) = _ktfx(JFXDialog(), block)

inline fun FxPanelNode.jfxDrawer(block: JFXDrawer.() -> Unit = {}) = _ktfx(JFXDrawer(), block)

inline fun FxPanelNode.jfxMasonryPane(block: JFXMasonryPane.() -> Unit = {}) = _ktfx(JFXMasonryPane(), block)

inline fun FxPanelNode.jfxBadge(block: JFXBadge.() -> Unit = {}) = _ktfx(JFXBadge(), block)

inline fun FxPanelNode.jfxSnackbar(block: JFXSnackbar.() -> Unit = {}) = _ktfx(JFXSnackbar(), block)

inline fun _Scene.decorator(block: FxPanelNodePanel.() -> Unit = {}): JFXDecorator {
    var decorator: JFXDecorator? = null
    _createFxPanelNodePanel {
        decorator = JFXDecorator(this.stage, it)
    }.apply(block)
    return decorator ?: JFXDecorator(stage, Group())
}

// TODO
inline fun <T : RecursiveTreeObject<T>> FxPanelNode.jfxTreeTableView(block: JFXTreeTableView<T>.() -> Unit = {}) = _ktfx(JFXTreeTableView(), block)

