package io.github.mslxl.ktgui.common

@KtDSL
interface PanelNode<in T> {
    fun _onAddToContent(comp: T)
}