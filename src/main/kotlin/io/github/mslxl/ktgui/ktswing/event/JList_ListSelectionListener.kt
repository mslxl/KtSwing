package io.github.mslxl.ktgui.ktswing.event

// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

fun javax.swing.JList<*>.listSelectionListener(init:(javax.swing.event.ListSelectionEvent)->Unit){
    addListSelectionListener(object:javax.swing.event.ListSelectionListener{
        
        override fun valueChanged(arg0:javax.swing.event.ListSelectionEvent){
                init.invoke(arg0)
        }


    })
}