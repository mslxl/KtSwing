package io.github.mslxl.ktgui.ktswing.event

// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

fun java.awt.Component.mouseWheelListener(init:(java.awt.event.MouseWheelEvent)->Unit){
    addMouseWheelListener(object:java.awt.event.MouseWheelListener{
        
        override fun mouseWheelMoved(arg0:java.awt.event.MouseWheelEvent){
                init.invoke(arg0)
        }


    })
}