package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.ChildrenScope
import io.github.mslxl.ktswing.FrameScope
import javax.swing.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T : JFrame> FrameScope<T>.menuBar(block: ChildrenScope<JMenuBar>.() -> Unit): JMenuBar {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menuBar = JMenuBar()
    ChildrenScope(menuBar).apply(block)
    self.jMenuBar = menuBar
    return menuBar
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenuBar>.menu(text: String, block: ChildrenScope<JMenu>.() -> Unit): JMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menu = JMenu(text)
    ChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

@OptIn(ExperimentalContracts::class)
@JvmName("menuJMenu")
inline fun ChildrenScope<JMenu>.menu(text: String, block: ChildrenScope<JMenu>.() -> Unit): JMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menu = JMenu(text)
    ChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.item(text: String, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(text), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.item(icon: Icon, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(icon), block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.item(text: String, icon: Icon, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(text, icon), block)
}


fun ChildrenScope<JMenu>.item(text: String) =
    item(text) {}

fun ChildrenScope<JMenu>.item(icon: Icon) =
    item(icon) {}

fun ChildrenScope<JMenu>.item(text: String, icon: Icon) =
    item(text, icon) {}


val ChildrenScope<JMenu>.separator: Unit
    get() = self.addSeparator()


@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.radioItem(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButtonMenuItem>.() -> Unit
): JRadioButtonMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    val btn = JRadioButtonMenuItem(text, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.radioItem(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButtonMenuItem>.() -> Unit
): JRadioButtonMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val btn = JRadioButtonMenuItem(icon, selected)
    group?.add(btn)
    return applyComponent(btn, block)
}

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.radioItem(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null,
    block: BasicScope<JRadioButtonMenuItem>.() -> Unit
): JRadioButtonMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
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

@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.checkItem(
    text: String,
    selected: Boolean = false,
    block: BasicScope<JCheckBoxMenuItem>.() -> Unit
): JCheckBoxMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JCheckBoxMenuItem(text, selected), block)
}


@OptIn(ExperimentalContracts::class)
inline fun ChildrenScope<JMenu>.checkItem(
    text: String,
    icon: Icon,
    selected: Boolean = false,
    block: BasicScope<JCheckBoxMenuItem>.() -> Unit
): JCheckBoxMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JCheckBoxMenuItem(text, icon, selected), block)
}

fun ChildrenScope<JMenu>.checkItem(text: String) =
    checkItem(text) {}

fun ChildrenScope<JMenu>.checkItem(text: String, icon: Icon) =
    checkItem(text, icon) {}
