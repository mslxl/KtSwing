package io.github.mslxl.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _WindowFocusListener(val component:java.awt.Window){

    // Code block 1
    
    private var windowGainedFocusField:((java.awt.event.WindowEvent)->Unit)? = null

    private var windowLostFocusField:((java.awt.event.WindowEvent)->Unit)? = null


    // Code block 2
    private val listener = object : java.awt.event.WindowFocusListener{
        
        override fun windowGainedFocus(arg0:java.awt.event.WindowEvent){
            windowGainedFocusField?.invoke(arg0)
        }

        override fun windowLostFocus(arg0:java.awt.event.WindowEvent){
            windowLostFocusField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addWindowFocusListener(listener)
    }

    // Code block 4
    
    fun onWindowGainedFocus(event:(java.awt.event.WindowEvent)->Unit){
        windowGainedFocusField = event
    }


    fun onWindowLostFocus(event:(java.awt.event.WindowEvent)->Unit){
        windowLostFocusField = event
    }


}

inline fun java.awt.Window.windowFocusListener(init: _WindowFocusListener.()->Unit) = _WindowFocusListener(this).apply(init)
