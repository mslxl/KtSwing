// Generate by KtSwing in ( Nov 25, 2017 11:46:47 AM )

fun java.awt.Component.mouseWheelListener(init:(java.awt.event.MouseWheelEvent)->Unit){
    addMouseWheelListener(object:java.awt.event.MouseWheelListener{
        
        override fun mouseWheelMoved(arg0:java.awt.event.MouseWheelEvent){
                init.invoke(arg0)
        }


    })
}