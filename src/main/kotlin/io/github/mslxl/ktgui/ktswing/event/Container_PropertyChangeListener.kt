package io.github.mslxl.ktgui.ktswing.event

// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

fun java.awt.Container.propertyChangeListener(init:(java.beans.PropertyChangeEvent)->Unit){
    addPropertyChangeListener(object:java.beans.PropertyChangeListener{
        
        override fun propertyChange(arg0:java.beans.PropertyChangeEvent){
                init.invoke(arg0)
        }


    })
}