package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Nov 25, 2017 1:08:28 PM )

fun java.awt.Component.mouseWheelListener(init:(java.awt.event.MouseWheelEvent)->Unit){
    addMouseWheelListener(object:java.awt.event.MouseWheelListener{
        
        override fun mouseWheelMoved(arg0:java.awt.event.MouseWheelEvent){
                init.invoke(arg0)
        }


    })
}