package io.github.mslxl.ktswing.event

import java.awt.Component
import java.awt.event.FocusEvent
import java.awt.event.FocusListener

class _FocusListener(container: Component){
    private var gained:((FocusEvent)->Unit)? = null
    private var lost:((FocusEvent)->Unit)? = null

    private val listener = object: FocusListener {
        override fun focusLost(e: FocusEvent) {
            gained?.invoke(e)
        }

        override fun focusGained(e: FocusEvent) {
            lost?.invoke(e)
        }

    }

    fun onFocusGained(event: (FocusEvent) -> Unit) {
        gained = event
    }

    fun onFocusLost(event: (FocusEvent) -> Unit) {
        lost = event
    }

    init {
        container.addFocusListener(listener)
    }
}

inline fun Component.addFocusListener(init: _FocusListener.()->Unit) = _FocusListener(this).apply(init)
