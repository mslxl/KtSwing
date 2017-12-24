package io.github.mslxl.ktswing.event
// Generate by KtSwing in ( Dec 24, 2017 9:16:43 AM )

class _FocusListener(val component:java.awt.Component){

    // Code block 1
    
    private var focusGainedField:((java.awt.event.FocusEvent)->Unit)? = null

    private var focusLostField:((java.awt.event.FocusEvent)->Unit)? = null


    // Code block 2
    private val listener = object : java.awt.event.FocusListener{
        
        override fun focusGained(arg0:java.awt.event.FocusEvent){
            focusGainedField?.invoke(arg0)
        }

        override fun focusLost(arg0:java.awt.event.FocusEvent){
            focusLostField?.invoke(arg0)
        }

    }

    // Code block 3
    init{
        component.addFocusListener(listener)
    }

    // Code block 4
    
    fun onFocusGained(event:(java.awt.event.FocusEvent)->Unit){
        focusGainedField = event
    }


    fun onFocusLost(event:(java.awt.event.FocusEvent)->Unit){
        focusLostField = event
    }


}

inline fun java.awt.Component.focusListener(init: _FocusListener.()->Unit) = _FocusListener(this).apply(init)
