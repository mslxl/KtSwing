package io.github.mslxl.ktswing

import javafx.scene.control.RadioButton
import java.awt.Component
import javax.swing.*

inline fun <E:Component> __ktswing(comp:E,parent:Content,init:E.()->Unit):E{
    parent.add(comp)
    init.invoke(comp)
    return comp
}

inline fun Content.label(text:String="",init:JLabel.()->Unit)= __ktswing(JLabel(text),this,init)
fun Content.label(text: String="") = label(text){}

inline fun Content.label(icon: Icon,init: JLabel.() -> Unit) = __ktswing(JLabel(icon),this,init)
fun Content.label(icon: Icon) = label(icon){}

inline fun Content.textfield(text:String="",init:JTextField.()->Unit) = __ktswing(JTextField(text),this,init)
fun Content.textfield(text:String=""):JTextField = textfield(text){}


inline fun Content.textarea(text:String="",init:JTextArea.()->Unit) = __ktswing(JTextArea(text),this,init)
fun Content.textarea(text: String=""):JTextArea = textarea(text){}

inline fun Content.button(text:String="",icon:Icon?=null,init: JButton.() -> Unit) = __ktswing(JButton(text,icon),this,init)
fun Content.button(text: String="",icon:Icon?=null)=button(text,icon){}

inline fun <E> Content.list(init: JList<E>.()->Unit) = __ktswing(JList<E>(),this,init)
fun Content.list()= list<kotlin.Any>(){}

inline fun Content.scrollPane(init:Content.()->Unit) = _createContent { __ktswing(JScrollPane(it),this){} }.apply(init)

inline fun Content.checkBox(text: String="",icon: Icon?=null,init:JCheckBox.()->Unit) = __ktswing(JCheckBox(text, icon),this,init)
fun Content.checkBox(text: String="",icon: Icon?=null) = checkBox(text, icon){}

inline fun Content.radioButton(text: String="",icon: Icon?=null,init: JRadioButton.()->Unit) = __ktswing(JRadioButton(text, icon),this,init)
fun Content.radioButton(text: String="",icon: Icon?=null) = radioButton(text, icon){}

inline fun <E> Content.comboBox(init: JComboBox<E>.()->Unit) = __ktswing(JComboBox<E>(),this,init)
fun Content.comboBox()= comboBox<kotlin.Any>(){}

inline fun Content.scrollBar(init: JScrollBar.()->Unit) = __ktswing(JScrollBar(),this,init)
fun Content.scrollBar() = scrollBar(){}

inline fun Content.progressBar(init: JProgressBar.()->Unit) = __ktswing(JProgressBar(),this,init)
fun Content.progressBar() = progressBar(){}

inline fun Content.slider(init: JSlider.()->Unit) = __ktswing(JSlider(),this,init)
fun Content.slider() = slider(){}

inline fun Content.spinner(init: JSpinner.()->Unit) = __ktswing(JSpinner(),this,init)
fun Content.spinner() = spinner(){}
