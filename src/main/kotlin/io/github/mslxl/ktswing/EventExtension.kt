package io.github.mslxl.ktswing

import java.awt.Container
import java.awt.event.*
import javax.swing.AbstractButton

fun AbstractButton.onClick(event: (ActionEvent) -> Unit) {
    addActionListener {
        event.invoke(it)
    }
}


class _MouseListener(container: Container) {

    private var released: ((MouseEvent) -> Unit)? = null
    private var entered: ((MouseEvent) -> Unit)? = null
    private var clicked: ((MouseEvent) -> Unit)? = null
    private var exited: ((MouseEvent) -> Unit)? = null
    private var pressed: ((MouseEvent) -> Unit)? = null

    private var moved: ((MouseEvent) -> Unit)? = null
    private var dragged: ((MouseEvent) -> Unit)? = null

    private var wheelMoved: ((MouseWheelEvent) -> Unit)? = null

    private val listener = object : MouseAdapter() {
        override fun mouseReleased(e: MouseEvent) {
            released?.invoke(e)
        }

        override fun mouseEntered(e: MouseEvent) {
            entered?.invoke(e)
        }

        override fun mouseClicked(e: MouseEvent) {
            clicked?.invoke(e)
        }

        override fun mouseExited(e: MouseEvent) {
            exited?.invoke(e)
        }

        override fun mousePressed(e: MouseEvent) {
            pressed?.invoke(e)
        }

        override fun mouseMoved(e: MouseEvent) {
            moved?.invoke(e)
        }

        override fun mouseDragged(e: MouseEvent) {
            dragged?.invoke(e)
        }

        override fun mouseWheelMoved(e: MouseWheelEvent) {
            wheelMoved?.invoke(e)
        }
    }

    init {
        container.addMouseListener(listener)
        container.addMouseWheelListener(listener)
        container.addMouseMotionListener(listener)
    }
    fun onMouseEntered(event: (MouseEvent) -> Unit) {
        entered = event
    }
    fun onMouseClicked(event: (MouseEvent) -> Unit) {
        clicked = event
    }

    fun onMouseReleased(event: (MouseEvent) -> Unit) {
        released = event
    }


    fun onMouseExited(event: (MouseEvent) -> Unit) {
        exited = event
    }

    fun onMousePressed(event: (MouseEvent) -> Unit) {
        pressed = event
    }

    fun onMouseMoved(event: (MouseEvent) -> Unit) {
        moved = event
    }

    fun onMouseDragged(event: (MouseEvent) -> Unit) {
        dragged = event
    }

    fun onMouseWheelMoved(event: (MouseWheelEvent) -> Unit) {
        wheelMoved = event
    }



}
inline fun Container.onMouseListener(init: _MouseListener.() -> Unit) = _MouseListener(this).apply(init)




fun Container.onKeyTyped(event: (KeyEvent) -> Unit) {
    addKeyListener(object : KeyAdapter() {
        override fun keyTyped(e: KeyEvent) {
            event.invoke(e)
        }
    })
}

fun Container.onKeyPressed(event: (KeyEvent) -> Unit) {
    addKeyListener(object : KeyAdapter() {
        override fun keyPressed(e: KeyEvent) {
            event.invoke(e)
        }
    })
}

fun Container.onKeyTypReleased(event: (KeyEvent) -> Unit) {
    addKeyListener(object : KeyAdapter() {
        override fun keyReleased(e: KeyEvent) {
            event.invoke(e)
        }
    })
}

fun Container.onFocusGained(event: (FocusEvent) -> Unit) {
    addFocusListener(object : FocusAdapter() {
        override fun focusGained(e: FocusEvent) {
            event.invoke(e)
        }
    })
}

fun Container.onFocusLost(event: (FocusEvent) -> Unit) {
    addFocusListener(object : FocusAdapter() {
        override fun focusLost(e: FocusEvent) {
            event.invoke(e)
        }
    })
}