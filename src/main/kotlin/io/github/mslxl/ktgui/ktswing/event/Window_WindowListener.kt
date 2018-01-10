package io.github.mslxl.ktgui.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _WindowListener(val component:java.awt.Window){

    // Code block 1
    
    private var windowOpenedField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowClosingField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowClosedField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowIconifiedField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowDeiconifiedField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowActivatedField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowDeactivatedField:((java.awt.event.WindowEvent)->Unit)? = null


    // Code block 2
    private val listener = object : java.awt.event.WindowListener{
        
        override fun windowOpened(arg0:java.awt.event.WindowEvent){
            windowOpenedField?.invoke(arg0)
        }

        override fun windowClosing(arg0:java.awt.event.WindowEvent){
            windowClosingField?.invoke(arg0)
        }

        override fun windowClosed(arg0:java.awt.event.WindowEvent){
            windowClosedField?.invoke(arg0)
        }

        override fun windowIconified(arg0:java.awt.event.WindowEvent){
            windowIconifiedField?.invoke(arg0)
        }

        override fun windowDeiconified(arg0:java.awt.event.WindowEvent){
            windowDeiconifiedField?.invoke(arg0)
        }

        override fun windowActivated(arg0:java.awt.event.WindowEvent){
            windowActivatedField?.invoke(arg0)
        }

        override fun windowDeactivated(arg0:java.awt.event.WindowEvent){
            windowDeactivatedField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addWindowListener(listener)
    }

    // Code block 4
    
    fun onWindowOpened(event:(java.awt.event.WindowEvent)->Unit){
        windowOpenedField = event
    }


    fun onWindowClosing(event:(java.awt.event.WindowEvent)->Unit){
        windowClosingField = event
    }


    fun onWindowClosed(event:(java.awt.event.WindowEvent)->Unit){
        windowClosedField = event
    }


    fun onWindowIconified(event:(java.awt.event.WindowEvent)->Unit){
        windowIconifiedField = event
    }


    fun onWindowDeiconified(event:(java.awt.event.WindowEvent)->Unit){
        windowDeiconifiedField = event
    }


    fun onWindowActivated(event:(java.awt.event.WindowEvent)->Unit){
        windowActivatedField = event
    }


    fun onWindowDeactivated(event:(java.awt.event.WindowEvent)->Unit){
        windowDeactivatedField = event
    }


}

inline fun java.awt.Window.windowListener(init: _WindowListener.()->Unit) = _WindowListener(this).apply(init)
