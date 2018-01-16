@file:JvmName("JFoenix")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.jfoenix

import com.jfoenix.controls.*
import io.github.mslxl.ktgui.ktfx.*
import javafx.scene.Node
import javafx.scene.control.Tab

inline fun FxPanelNode.jfxRippler() = _ktfx(JFXRippler())


inline fun FxPanelNode.jfxRippler(block: FxPanelNode.() -> Unit): JFXRippler {
    var rippler: Node? = null
    _createFxPanelNode {
        rippler = it
        it._ktfxInit()
    }.apply(block)
    val jfx = JFXRippler(rippler)
    this._ktfx(jfx)
    return jfx
}

inline fun FxPanelNode.jfxButton(text: String = "", block: JFXButton.() -> Unit = {}) = _ktfx(JFXButton(text), block)

inline fun FxPanelNode.jfxToggleButton(block: JFXToggleButton.() -> Unit = {}) = _ktfx(JFXToggleButton(), block)

inline fun FxPanelNode.jfxCheckBox(text: String = "", block: JFXCheckBox.() -> Unit = {}) = _ktfx(JFXCheckBox(text), block)

inline fun FxPanelNode.jfxRadioButton(text: String = "", block: JFXRadioButton.() -> Unit = {}) = _ktfx(JFXRadioButton(text), block)

inline fun FxPanelNode.jfxHamburger(block: JFXHamburger.() -> Unit = {}) = _ktfx(JFXHamburger(), block)

inline fun <T> FxPanelNode.jfxComboBox(block: JFXComboBox<T>.() -> Unit = {}) = _ktfx(JFXComboBox(), block)

inline fun FxPanelNode.jfxTextField(text: String = "", block: JFXTextField.() -> Unit = {}) = _ktfx(JFXTextField(text), block)

inline fun FxPanelNode.jfxProgressBar(block: JFXProgressBar.() -> Unit = {}) = _ktfx(JFXProgressBar(), block)

inline fun FxPanelNode.jfxSlider(block: JFXSlider.() -> Unit = {}) = _ktfx(JFXSlider(), block)

inline fun FxPanelNode.jfxSpinner(block: JFXSpinner.() -> Unit = {}) = _ktfx(JFXSpinner(), block)


class _JFXTabPane : JFXTabPane() {
    inline fun tab(title: String = "", block: _Tab.() -> Unit) {
        _Tab(title)._ktfxInit().apply(block).let {
            tabs.add(it)
        }
    }

    class _Tab(text: String) : Tab(text), FxPanelNode {
        override fun _onAddToContent(comp: Node) {
            content = comp._ktfxInit()
        }
    }
}

inline fun FxPanelNodePanel.jfxTabPane(block: _JFXTabPane.() -> Unit) = _ktfx(_JFXTabPane(), block)