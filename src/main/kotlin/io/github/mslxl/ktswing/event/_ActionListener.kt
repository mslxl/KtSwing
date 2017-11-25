// Generate by KtSwing in ( Nov 25, 2017 11:46:47 AM )

fun javax.swing.AbstractButton.actionListener(init:(java.awt.event.ActionEvent)->Unit){
    addActionListener(object:java.awt.event.ActionListener{
        
        override fun actionPerformed(arg0:java.awt.event.ActionEvent){
                init.invoke(arg0)
        }


    })
}