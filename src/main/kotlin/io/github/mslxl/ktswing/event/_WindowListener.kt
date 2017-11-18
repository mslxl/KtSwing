package io.github.mslxl.ktswing.event

import java.awt.Window
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

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

    private val listener = object : WindowAdapter(){
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

inline fun Window.addWindowListener(init: _WindowListener.()->Unit) = _WindowListener(this).apply(init)