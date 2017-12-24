package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

fun javax.swing.JTree.treeSelectionListener(init:(javax.swing.event.TreeSelectionEvent)->Unit){
    addTreeSelectionListener(object:javax.swing.event.TreeSelectionListener{
        
        override fun valueChanged(arg0:javax.swing.event.TreeSelectionEvent){
                init.invoke(arg0)
        }


    })
}