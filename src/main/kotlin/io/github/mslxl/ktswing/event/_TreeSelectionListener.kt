package io.github.mslxl.ktswing.event

// Generate by KtSwing in ( Nov 26, 2017 2:19:20 PM )

fun javax.swing.JTree.treeSelectionListener(init:(javax.swing.event.TreeSelectionEvent)->Unit){
    addTreeSelectionListener(object:javax.swing.event.TreeSelectionListener{
        
        override fun valueChanged(arg0:javax.swing.event.TreeSelectionEvent){
                init.invoke(arg0)
        }


    })
}