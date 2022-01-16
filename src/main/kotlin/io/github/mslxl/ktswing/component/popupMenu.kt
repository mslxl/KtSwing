package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import javax.swing.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun BasicScope<JComponent>.showPopupMenu(
    x: Int,
    y: Int,
    show: Boolean = true,
    block: CanAddChildrenScope<JPopupMenu>.() -> Unit
): JPopupMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val popup = JPopupMenu()
    CanAddChildrenScope(popup).apply(block)

    if (show) {
        popup.show(self, x, y)
    }
    return popup

}

@OptIn(ExperimentalContracts::class)
inline fun JComponent.showPopupMenu(
    x: Int,
    y: Int,
    show: Boolean = true,
    block: CanAddChildrenScope<JPopupMenu>.() -> Unit
): JPopupMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return BasicScope(this).showPopupMenu(x, y, show, block)
}


@OptIn(ExperimentalContracts::class)
@JvmName("menuJMenu")
inline fun CanAddChildrenScope<JPopupMenu>.menu(text: String, block: CanAddChildrenScope<JMenu>.() -> Unit): JMenu {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val menu = JMenu(text)
    CanAddChildrenScope(menu).apply(block)
    add(menu)
    return menu
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JPopupMenu>.item(text: String, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(text), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JPopupMenu>.item(icon: Icon, block: BasicScope<JMenuItem>.() -> Unit): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(icon), block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JPopupMenu>.item(
    text: String,
    icon: Icon,
    block: BasicScope<JMenuItem>.() -> Unit
): JMenuItem {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JMenuItem(text, icon), block)
}


fun CanAddChildrenScope<JPopupMenu>.item(text: String) =
    item(text) {}

fun CanAddChildrenScope<JPopupMenu>.item(icon: Icon) =
    item(icon) {}

fun CanAddChildrenScope<JPopupMenu>.item(text: String, icon: Icon) =
    item(text, icon) {}


val CanAddChildrenScope<JPopupMenu>.separator: Unit
    get() = self.addSeparator()


@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JPopupMenu>.radioItem(
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
inline fun CanAddChildrenScope<JPopupMenu>.radioItem(
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
inline fun CanAddChildrenScope<JPopupMenu>.radioItem(
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

fun CanAddChildrenScope<JPopupMenu>.radioItem(
    text: String,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(text, selected, group) {}

fun CanAddChildrenScope<JPopupMenu>.radioItem(
    icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(icon, selected, group) {}

fun CanAddChildrenScope<JPopupMenu>.radioItem(
    text: String, icon: Icon,
    selected: Boolean = false,
    group: ButtonGroup? = null
) = radioItem(text, icon, selected, group) {}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<JPopupMenu>.checkItem(
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
inline fun CanAddChildrenScope<JPopupMenu>.checkItem(
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

fun CanAddChildrenScope<JPopupMenu>.checkItem(text: String) =
    checkItem(text) {}

fun CanAddChildrenScope<JPopupMenu>.checkItem(text: String, icon: Icon) =
    checkItem(text, icon) {}
