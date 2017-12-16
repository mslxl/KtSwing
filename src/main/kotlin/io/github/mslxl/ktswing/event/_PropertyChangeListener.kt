package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Dec 16, 2017 9:49:32 PM )

fun java.awt.Container.propertyChangeListener(init:(java.beans.PropertyChangeEvent)->Unit){
    addPropertyChangeListener(object:java.beans.PropertyChangeListener{
        
        override fun propertyChange(arg0:java.beans.PropertyChangeEvent){
                init.invoke(arg0)
        }


    })
}