// Generate by KtSwing in ( Nov 25, 2017 11:46:47 AM )

fun javax.swing.JList<*>.listSelectionListener(init:(javax.swing.event.ListSelectionEvent)->Unit){
    addListSelectionListener(object:javax.swing.event.ListSelectionListener{
        
        override fun valueChanged(arg0:javax.swing.event.ListSelectionEvent){
                init.invoke(arg0)
        }


    })
}