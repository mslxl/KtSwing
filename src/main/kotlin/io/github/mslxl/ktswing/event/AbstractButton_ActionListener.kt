package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

fun javax.swing.AbstractButton.actionListener(init:(java.awt.event.ActionEvent)->Unit){
    addActionListener(object:java.awt.event.ActionListener{
        
        override fun actionPerformed(arg0:java.awt.event.ActionEvent){
                init.invoke(arg0)
        }


    })
}