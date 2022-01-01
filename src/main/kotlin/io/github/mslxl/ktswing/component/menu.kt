package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.FrameScope
import javax.swing.*

inline fun <T : JFrame> FrameScope<T>.menuBar(block: ChildrenScope<JMenuBar>.() -> Unit): JMenuBar {
    val menuBar = JMenuBar()
    ChildrenScope(menuBar).apply(block)
    self.jMenuBar = menuBar
    return menuBar
}

inline fun ChildrenScope<JMenuBar>.menu(text: String, block: ChildrenScope<JMenu>.() -> Unit): JMenu {
    val menu = JMenu(text)
    ChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

@JvmName("menuJMenu")
inline fun ChildrenScope<JMenu>.menu(text: String, block: ChildrenScope<JMenu>.() -> Unit): JMenu {
    val menu = JMenu(text)
    ChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

inline fun ChildrenScope<JMenu>.item(text: String, block: BasicScope<JMenuItem>.() -> Unit) =
    applyComponent(JMenuItem(text), block)

inline fun ChildrenScope<JMenu>.item(icon: Icon, block: BasicScope<JMenuItem>.() -> Unit) =
    applyComponent(JMenuItem(icon), block)

inline fun ChildrenScope<JMenu>.item(text: String, icon: Icon, block: BasicScope<JMenuItem>.() -> Unit) =
    applyComponent(JMenuItem(text, icon), block)


fun ChildrenScope<JMenu>.item(text: String) =
    item(text) {}

fun ChildrenScope<JMenu>.item(icon: Icon) =
    item(icon) {}

fun ChildrenScope<JMenu>.item(text: String, icon: Icon) =
    item(text, icon) {}


val ChildrenScope<JMenu>.separator: Unit
    get() = self.addSeparator()


inline fun ChildrenScope<JMenu>.radioItem(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButtonMenuItem>.() -> Unit
): JRadioButtonMenuItem {
    val btn = JRadioButtonMenuItem(text, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

inline fun ChildrenScope<JMenu>.radioItem(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButtonMenuItem>.() -> Unit
): JRadioButtonMenuItem {
    val btn = JRadioButtonMenuItem(icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

inline fun ChildrenScope<JMenu>.radioItem(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButtonMenuItem>.() -> Unit
): JRadioButtonMenuItem {
    val btn = JRadioButtonMenuItem(text, icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

fun ChildrenScope<JMenu>.radioItem(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(text, selected, group) {}

fun ChildrenScope<JMenu>.radioItem(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(icon, selected, group) {}

fun ChildrenScope<JMenu>.radioItem(
    text: String, icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(text, icon, selected, group) {}

inline fun ChildrenScope<JMenu>.checkItem(
    text: String,
    selected: Boolean = false,
    block: BasicScope<JCheckBoxMenuItem>.() -> Unit
) = applyComponent(JCheckBoxMenuItem(text, selected), block)


inline fun ChildrenScope<JMenu>.checkItem(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JCheckBoxMenuItem>.() -> Unit
) = applyComponent(JCheckBoxMenuItem(text, icon, selected), block)

fun ChildrenScope<JMenu>.checkItem(text: String) =
    checkItem(text) {}

fun ChildrenScope<JMenu>.checkItem(text: String, icon: Icon) =
    checkItem(text, icon) {}
