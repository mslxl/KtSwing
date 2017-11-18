package io.github.mslxl.ktswing.event

import java.awt.Component
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class _KeyListener(container: Component){
    private var typed: ((KeyEvent) -> Unit)? = null
    private var pressed: ((KeyEvent) -> Unit)? = null
    private var released: ((KeyEvent) -> Unit)? = null

    private val listener = object : KeyListener {
        override fun keyTyped(e: KeyEvent){
            typed?.invoke(e)
        }
        override fun keyPressed(e: KeyEvent) {
            pressed?.invoke(e)
        }

        override fun keyReleased(e: KeyEvent) {
            released?.invoke(e)
        }
    }

    fun onKeyTyped(event: (KeyEvent) -> Unit) {
        typed = event
    }

    fun onKeyPressed(event: (KeyEvent) -> Unit) {
        pressed = event
    }

    fun onKeyTypReleased(event: (KeyEvent) -> Unit) {
        released = event
    }

    init {
        container.addKeyListener(listener)
    }
}
inline fun Component.addKeyListener(init: _KeyListener.()->Unit) = _KeyListener(this).apply(init)
