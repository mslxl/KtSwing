import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.event.actionListener
import java.awt.GridBagConstraints
import java.awt.Insets
import javax.swing.*

fun main(args: Array<String>) {

    val template = UI{
        val insets = Insets(5, 5, 5, 5)
        gridbagpanel {
            border = BorderFactory.createEtchedBorder()

            constraints(0, 0, 1, insets = insets) {
                label(){
                    name = "label"
                }
            }
            constraints(1, 0, 17, fill = GridBagConstraints.BOTH, weightX = 17.0, insets = insets) {
                textfield {
                    name = "textfield"

                }
            }
            constraints(18, 0, 2, insets = insets) {
                button(){
                    name = "button"
                    actionListener {
                        JOptionPane.showMessageDialog(this,this.name+"\n\nAnd you was input:${findComponentByName<JTextField>("textfield")!!.text}")
                        name+="1"
                    }
                }
            }
        }
    }.createTemplate {

        key("labelText","label"){
            value, comp,_ ->
            if (comp is JLabel){
                comp.text = value.toString()
            }
        }

        key("buttonNumber","button"){
            value, comp,prefix ->
            if (comp is JButton){
                comp.text = "Click me to show my name ($value)"
            }
        }

    }


    frame {
        exitOnClose
        gridlayout(0,1,5,5){
            this include template.createJComponent("first","labelText" to "Enter text:","buttonNumber" to 1)
            this include template.createJComponent("第二组","labelText" to "Enter text:","buttonNumber" to 2)
            this include template.createJComponent("さんばんめ","labelText" to "Enter text:","buttonNumber" to 3)
        }

        pack()
    }
}