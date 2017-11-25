package io.github.mslxl.ktswing.event
// Generate by KtSwing in ( Nov 25, 2017 1:08:28 PM )

class _MouseListener(val component:java.awt.Component){

    // Code block 1
    
    private var mousePressedField:((java.awt.event.MouseEvent)->Unit)? = null

    private var mouseReleasedField:((java.awt.event.MouseEvent)->Unit)? = null

    private var mouseClickedField:((java.awt.event.MouseEvent)->Unit)? = null

    private var mouseExitedField:((java.awt.event.MouseEvent)->Unit)? = null

    private var mouseEnteredField:((java.awt.event.MouseEvent)->Unit)? = null


    // Code block 2
    private val listener = object : java.awt.event.MouseListener{
        
        override fun mousePressed(arg0:java.awt.event.MouseEvent){
            mousePressedField?.invoke(arg0)
        }

        override fun mouseReleased(arg0:java.awt.event.MouseEvent){
            mouseReleasedField?.invoke(arg0)
        }

        override fun mouseClicked(arg0:java.awt.event.MouseEvent){
            mouseClickedField?.invoke(arg0)
        }

        override fun mouseExited(arg0:java.awt.event.MouseEvent){
            mouseExitedField?.invoke(arg0)
        }

        override fun mouseEntered(arg0:java.awt.event.MouseEvent){
            mouseEnteredField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addMouseListener(listener)
    }

    // Code block 4
    
    fun onMousePressed(event:(java.awt.event.MouseEvent)->Unit){
        mousePressedField = event
    }


    fun onMouseReleased(event:(java.awt.event.MouseEvent)->Unit){
        mouseReleasedField = event
    }


    fun onMouseClicked(event:(java.awt.event.MouseEvent)->Unit){
        mouseClickedField = event
    }


    fun onMouseExited(event:(java.awt.event.MouseEvent)->Unit){
        mouseExitedField = event
    }


    fun onMouseEntered(event:(java.awt.event.MouseEvent)->Unit){
        mouseEnteredField = event
    }


}

inline fun java.awt.Component.mouseListener(init: _MouseListener.()->Unit) = _MouseListener(this).apply(init)
