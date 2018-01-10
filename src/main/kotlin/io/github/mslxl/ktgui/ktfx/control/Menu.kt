@file:JvmName("Control")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.control

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.control.MenuBar

inline fun FxPanelNode.menuBar(init: MenuBar.()->Unit={}) = _ktfx(MenuBar(),init)