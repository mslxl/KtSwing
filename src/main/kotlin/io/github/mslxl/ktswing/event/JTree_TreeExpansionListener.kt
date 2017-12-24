package io.github.mslxl.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _TreeExpansionListener(val component:javax.swing.JTree){

    // Code block 1
    
    private var treeExpandedField:((javax.swing.event.TreeExpansionEvent)->Unit)? = null

    private var treeCollapsedField:((javax.swing.event.TreeExpansionEvent)->Unit)? = null


    // Code block 2
    private val listener = object : javax.swing.event.TreeExpansionListener{
        
        override fun treeExpanded(arg0:javax.swing.event.TreeExpansionEvent){
            treeExpandedField?.invoke(arg0)
        }

        override fun treeCollapsed(arg0:javax.swing.event.TreeExpansionEvent){
            treeCollapsedField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addTreeExpansionListener(listener)
    }

    // Code block 4
    
    fun onTreeExpanded(event:(javax.swing.event.TreeExpansionEvent)->Unit){
        treeExpandedField = event
    }


    fun onTreeCollapsed(event:(javax.swing.event.TreeExpansionEvent)->Unit){
        treeCollapsedField = event
    }


}

inline fun javax.swing.JTree.treeExpansionListener(init: _TreeExpansionListener.()->Unit) = _TreeExpansionListener(this).apply(init)
