package io.github.mslxl.ktswing

import java.awt.Component
import java.awt.Container
import java.awt.Window
import java.awt.event.*
import java.io.File
import javax.swing.AbstractButton
import kotlin.concurrent.thread

fun AbstractButton.onActionPerformed(event: (ActionEvent) -> Unit) {
    addActionListener {
        event.invoke(it)
    }
}


class _MouseListener(container: Component) {

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
inline fun Component.addMouseListener(init: _MouseListener.() -> Unit) = _MouseListener(this).apply(init)


class _KeyListener(container: Component){
    private var typed: ((KeyEvent) -> Unit)? = null
    private var pressed: ((KeyEvent) -> Unit)? = null
    private var released: ((KeyEvent) -> Unit)? = null

    private val listener = object :KeyListener{
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
inline fun Component.addKeyListener(init:_KeyListener.()->Unit) = _KeyListener(this).apply(init)

class _FocusListener(container: Component){
    private var gained:((FocusEvent)->Unit)? = null
    private var lost:((FocusEvent)->Unit)? = null

    private val listener = object:FocusListener{
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

inline fun Component.addFocusListener(init:_FocusListener.()->Unit) = _FocusListener(this).apply(init)

class _WindowListener(container: Window){
    private var deiconified:((WindowEvent)->Unit)? = null
    private var activated:((WindowEvent)->Unit)? = null
    private var deactivated:((WindowEvent)->Unit)? = null
    private var stateChanged:((WindowEvent)->Unit)? = null
    private var iconified:((WindowEvent)->Unit)? = null
    private var closing:((WindowEvent)->Unit)? = null
    private var lostFocus:((WindowEvent)->Unit)? = null
    private var closed:((WindowEvent)->Unit)? = null
    private var opened:((WindowEvent)->Unit)? = null
    private var gainedFocus:((WindowEvent)->Unit)? = null

    fun onDeiconified(event:(WindowEvent)->Unit){
        deiconified = event
    }
    fun onActivated(event:(WindowEvent)->Unit){
        activated = event
    }

    fun onDeactivated(event:(WindowEvent)->Unit){
        deactivated = event
    }

    fun onStateChanged(event:(WindowEvent)->Unit){
        stateChanged = event
    }
    fun onIconified(event:(WindowEvent)->Unit){
        iconified = event
    }
    fun onClosing(event:(WindowEvent)->Unit){
        closing = event
    }
    fun onLostFocus(event:(WindowEvent)->Unit){
        lostFocus = event
    }
    fun onClosed(event:(WindowEvent)->Unit){
        closed = event
    }
    fun onOpened(event:(WindowEvent)->Unit){
        opened = event
    }
    fun onGainedFocus(event:(WindowEvent)->Unit){
        gainedFocus = event
    }

    private val listener = object :WindowAdapter(){
        override fun windowDeiconified(e: WindowEvent) {
            deiconified?.invoke(e)
        }

        override fun windowActivated(e: WindowEvent) {
            activated?.invoke(e)
        }

        override fun windowDeactivated(e: WindowEvent) {
            deactivated?.invoke(e)
        }

        override fun windowStateChanged(e: WindowEvent) {
            stateChanged?.invoke(e)
        }

        override fun windowIconified(e: WindowEvent) {
            iconified?.invoke(e)
        }

        override fun windowClosing(e: WindowEvent) {
            closing?.invoke(e)
        }

        override fun windowLostFocus(e: WindowEvent) {
            lostFocus?.invoke(e)
        }

        override fun windowClosed(e: WindowEvent) {
            closed?.invoke(e)
        }

        override fun windowOpened(e: WindowEvent) {
            opened?.invoke(e)
        }

        override fun windowGainedFocus(e: WindowEvent) {
            gainedFocus?.invoke(e)
        }


    }

    init {
        container.addWindowListener(listener)
    }
}

inline fun Window.addWindowListener(init:_WindowListener.()->Unit) = _WindowListener(this).apply(init)