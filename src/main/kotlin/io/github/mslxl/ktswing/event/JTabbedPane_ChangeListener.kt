package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

fun javax.swing.JTabbedPane.changeListener(init:(javax.swing.event.ChangeEvent)->Unit){
    addChangeListener(object:javax.swing.event.ChangeListener{
        
        override fun stateChanged(arg0:javax.swing.event.ChangeEvent){
                init.invoke(arg0)
        }


    })
}