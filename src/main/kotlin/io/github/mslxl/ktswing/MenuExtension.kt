package io.github.mslxl.ktswing

import javax.swing.*

inline fun JFrame.menubar(init: JMenuBar.() -> Unit) = JMenuBar().apply { this@menubar.jMenuBar = this }.apply(init)

inline fun JMenuBar.menu(text: String = "", init: JMenu.() -> Unit) = JMenu(text).apply { this@menu.add(this) }.apply(init)
fun JMenuBar.menu(text: String = "") = menu(text) {}

inline fun JMenu.menuItem(text: String = "", init: JMenuItem.() -> Unit) = JMenuItem(text).apply { this@menuItem.add(this) }.apply(init)
fun JMenu.menuItem(text: String = "") = menuItem(text) {}

inline fun JMenu.checkBoxMenuItem(text: String = "", icon: Icon? = null, init: JCheckBoxMenuItem.() -> Unit) = JCheckBoxMenuItem(text, icon).apply { this@checkBoxMenuItem.add(this) }.apply(init)
fun JMenu.checkBoxMenuItem(text: String = "", icon: Icon? = null) = checkBoxMenuItem(text, icon) {}

inline fun JMenu.radioButtonMenuItem(text: String,icon: Icon?=null,init: JRadioButtonMenuItem.() -> Unit) = JRadioButtonMenuItem(text,icon).apply { this@radioButtonMenuItem.add(this) }.apply(init)
fun JMenu.radioButtonMenuItem(text: String,icon: Icon?=null)=radioButtonMenuItem(text, icon){}

fun JMenu.separator() = this.addSeparator()