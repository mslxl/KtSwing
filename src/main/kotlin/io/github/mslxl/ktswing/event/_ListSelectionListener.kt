package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Nov 25, 2017 1:08:28 PM )

fun javax.swing.JList<*>.listSelectionListener(init:(javax.swing.event.ListSelectionEvent)->Unit){
    addListSelectionListener(object:javax.swing.event.ListSelectionListener{
        
        override fun valueChanged(arg0:javax.swing.event.ListSelectionEvent){
                init.invoke(arg0)
        }


    })
}