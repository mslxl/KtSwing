package io.github.mslxl.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _PopupMenuListener(val component:javax.swing.JComboBox<*>){

    // Code block 1
    
    private var popupMenuWillBecomeVisibleField:((javax.swing.event.PopupMenuEvent)->Unit)? = null

    private var popupMenuWillBecomeInvisibleField:((javax.swing.event.PopupMenuEvent)->Unit)? = null

    private var popupMenuCanceledField:((javax.swing.event.PopupMenuEvent)->Unit)? = null


    // Code block 2
    private val listener = object : javax.swing.event.PopupMenuListener{
        
        override fun popupMenuWillBecomeVisible(arg0:javax.swing.event.PopupMenuEvent){
            popupMenuWillBecomeVisibleField?.invoke(arg0)
        }

        override fun popupMenuWillBecomeInvisible(arg0:javax.swing.event.PopupMenuEvent){
            popupMenuWillBecomeInvisibleField?.invoke(arg0)
        }

        override fun popupMenuCanceled(arg0:javax.swing.event.PopupMenuEvent){
            popupMenuCanceledField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addPopupMenuListener(listener)
    }

    // Code block 4
    
    fun onPopupMenuWillBecomeVisible(event:(javax.swing.event.PopupMenuEvent)->Unit){
        popupMenuWillBecomeVisibleField = event
    }


    fun onPopupMenuWillBecomeInvisible(event:(javax.swing.event.PopupMenuEvent)->Unit){
        popupMenuWillBecomeInvisibleField = event
    }


    fun onPopupMenuCanceled(event:(javax.swing.event.PopupMenuEvent)->Unit){
        popupMenuCanceledField = event
    }


}

inline fun javax.swing.JComboBox<*>.popupMenuListener(init: _PopupMenuListener.()->Unit) = _PopupMenuListener(this).apply(init)
