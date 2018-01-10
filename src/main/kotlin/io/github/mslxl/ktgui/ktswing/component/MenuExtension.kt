@file:JvmName("Component")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.component

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

val JMenu.separator:Unit
    get() = this.addSeparator()


inline fun JPopupMenu.menuItem(text: String = "", init: JMenuItem.() -> Unit) = JMenuItem(text).apply { this@menuItem.add(this) }.apply(init)
fun JPopupMenu.menuItem(text: String = "") = menuItem(text) {}

inline fun JPopupMenu.checkBoxMenuItem(text: String = "", icon: Icon? = null, init: JCheckBoxMenuItem.() -> Unit) = JCheckBoxMenuItem(text, icon).apply { this@checkBoxMenuItem.add(this) }.apply(init)
fun JPopupMenu.checkBoxMenuItem(text: String = "", icon: Icon? = null) = checkBoxMenuItem(text, icon) {}

inline fun JPopupMenu.radioButtonMenuItem(text: String,icon: Icon?=null,init: JRadioButtonMenuItem.() -> Unit) = JRadioButtonMenuItem(text,icon).apply { this@radioButtonMenuItem.add(this) }.apply(init)
fun JPopupMenu.radioButtonMenuItem(text: String,icon: Icon?=null)=radioButtonMenuItem(text, icon){}

val JPopupMenu.separator:Unit
    get() = this.addSeparator()
