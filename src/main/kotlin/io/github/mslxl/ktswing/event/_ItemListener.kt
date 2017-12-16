package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Dec 16, 2017 9:49:32 PM )

fun javax.swing.JComboBox<*>.itemListener(init:(java.awt.event.ItemEvent)->Unit){
    addItemListener(object:java.awt.event.ItemListener{
        
        override fun itemStateChanged(arg0:java.awt.event.ItemEvent){
                init.invoke(arg0)
        }


    })
}