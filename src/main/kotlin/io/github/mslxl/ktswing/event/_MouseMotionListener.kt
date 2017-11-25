// Generate by KtSwing in ( Nov 25, 2017 11:46:47 AM )

class _MouseMotionListener(val component:java.awt.Component){

    // Code block 1
    
    private var mouseMovedField:((java.awt.event.MouseEvent)->Unit)? = null

    private var mouseDraggedField:((java.awt.event.MouseEvent)->Unit)? = null


    // Code block 2
    private val listener = object : java.awt.event.MouseMotionListener{
        
        override fun mouseMoved(arg0:java.awt.event.MouseEvent){
            mouseMovedField?.invoke(arg0)
        }

        override fun mouseDragged(arg0:java.awt.event.MouseEvent){
            mouseDraggedField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addMouseMotionListener(listener)
    }

    // Code block 4
    
    fun onMouseMoved(event:(java.awt.event.MouseEvent)->Unit){
        mouseMovedField = event
    }


    fun onMouseDragged(event:(java.awt.event.MouseEvent)->Unit){
        mouseDraggedField = event
    }


}

inline fun java.awt.Component.mouseMotionListener(init: _MouseMotionListener.()->Unit) = _MouseMotionListener(this).apply(init)
