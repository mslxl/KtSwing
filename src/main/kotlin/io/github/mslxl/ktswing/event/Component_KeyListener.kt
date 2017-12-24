package io.github.mslxl.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _KeyListener(val component:java.awt.Component){

    // Code block 1
    
    private var keyTypedField:((java.awt.event.KeyEvent)->Unit)? = null

    private var keyPressedField:((java.awt.event.KeyEvent)->Unit)? = null

    private var keyReleasedField:((java.awt.event.KeyEvent)->Unit)? = null


    // Code block 2
    private val listener = object : java.awt.event.KeyListener{
        
        override fun keyTyped(arg0:java.awt.event.KeyEvent){
            keyTypedField?.invoke(arg0)
        }

        override fun keyPressed(arg0:java.awt.event.KeyEvent){
            keyPressedField?.invoke(arg0)
        }

        override fun keyReleased(arg0:java.awt.event.KeyEvent){
            keyReleasedField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addKeyListener(listener)
    }

    // Code block 4
    
    fun onKeyTyped(event:(java.awt.event.KeyEvent)->Unit){
        keyTypedField = event
    }


    fun onKeyPressed(event:(java.awt.event.KeyEvent)->Unit){
        keyPressedField = event
    }


    fun onKeyReleased(event:(java.awt.event.KeyEvent)->Unit){
        keyReleasedField = event
    }


}

inline fun java.awt.Component.keyListener(init: _KeyListener.()->Unit) = _KeyListener(this).apply(init)
