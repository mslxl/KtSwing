package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.FrameScope
import javax.swing.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T : JFrame> FrameScope<T>.menuBar(block: CanAddChildrenScope<JMenuBar>.() -> Unit): JMenuBar {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menuBar = JMenuBar()
    CanAddChildrenScope(menuBar).apply(block)
    self.jMenuBar = menuBar
    return menuBar
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JMenuBar>.menu(text: String, block: CanAddChildrenScope<JMenu>.() -> Unit): JMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menu = JMenu(text)
    CanAddChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

@OptIn(ExperimentalContracts::class)
@JvmName("menuJMenu")
inline fun CanAddChildrenScope<JMenu>.menu(text: String, block: CanAddChildrenScope<JMenu>.() -> Unit): JMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menu = JMenu(text)
    CanAddChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JMenu>.item(text: String, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(text), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JMenu>.item(icon: Icon, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(icon), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JMenu>.item(
    text: String,
    icon: Icon,
    block: BasicScope<JMenuItem>.() -> Unit
): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(text, icon), block)
}


fun CanAddChildrenScope<JMenu>.item(text: String) =
    item(text) {}

fun CanAddChildrenScope<JMenu>.item(icon: Icon) =
    item(icon) {}

fun CanAddChildrenScope<JMenu>.item(text: String, icon: Icon) =
    item(text, icon) {}


val CanAddChildrenScope<JMenu>.separator: Unit
    get() = self.addSeparator()


@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JMenu>.radioItem(
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
inline fun CanAddChildrenScope<JMenu>.radioItem(
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
inline fun CanAddChildrenScope<JMenu>.radioItem(
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

fun CanAddChildrenScope<JMenu>.radioItem(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(text, selected, group) {}

fun CanAddChildrenScope<JMenu>.radioItem(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(icon, selected, group) {}

fun CanAddChildrenScope<JMenu>.radioItem(
    text: String, icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(text, icon, selected, group) {}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JMenu>.checkItem(
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
inline fun CanAddChildrenScope<JMenu>.checkItem(
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

fun CanAddChildrenScope<JMenu>.checkItem(text: String) =
    checkItem(text) {}

fun CanAddChildrenScope<JMenu>.checkItem(text: String, icon: Icon) =
    checkItem(text, icon) {}
