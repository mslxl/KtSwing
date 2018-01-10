package io.github.mslxl.ktgui.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _TreeWillExpandListener(val component:javax.swing.JTree){

    // Code block 1
    
    private var treeWillExpandField:((javax.swing.event.TreeExpansionEvent)->Unit)? = null

    private var treeWillCollapseField:((javax.swing.event.TreeExpansionEvent)->Unit)? = null


    // Code block 2
    private val listener = object : javax.swing.event.TreeWillExpandListener{
        
        override fun treeWillExpand(arg0:javax.swing.event.TreeExpansionEvent){
            treeWillExpandField?.invoke(arg0)
        }

        override fun treeWillCollapse(arg0:javax.swing.event.TreeExpansionEvent){
            treeWillCollapseField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addTreeWillExpandListener(listener)
    }

    // Code block 4
    
    fun onTreeWillExpand(event:(javax.swing.event.TreeExpansionEvent)->Unit){
        treeWillExpandField = event
    }


    fun onTreeWillCollapse(event:(javax.swing.event.TreeExpansionEvent)->Unit){
        treeWillCollapseField = event
    }


}

inline fun javax.swing.JTree.treeWillExpandListener(init: _TreeWillExpandListener.()->Unit) = _TreeWillExpandListener(this).apply(init)
