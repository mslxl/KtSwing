package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Dec 16, 2017 9:52:46 PM )

fun javax.swing.JTabbedPane.changeListener(init:(javax.swing.event.ChangeEvent)->Unit){
    addChangeListener(object:javax.swing.event.ChangeListener{
        
        override fun stateChanged(arg0:javax.swing.event.ChangeEvent){
                init.invoke(arg0)
        }


    })
}