@file:Suppress("unused")

package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import java.net.URL
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.JLabel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.label(
    text: String = "",
    icon: Icon? = null,
    horizontalAlignment: Int = JLabel.LEADING,
    block: BasicScope<JLabel>.() -> Unit
): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return applyComponent(JLabel(text, icon, horizontalAlignment), block)
}

fun CanAddChildrenScope<*>.label(
    text: String = "",
    icon: Icon? = null,
    horizontalAlignment: Int = JLabel.LEADING,
) = label(text, icon, horizontalAlignment) {}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.imageLabel(
    icon: Icon? = null,
    block: BasicScope<JLabel>.() -> Unit
): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return label(icon = icon, block = block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.imageLabel(
    url: URL,
    block: BasicScope<JLabel>.() -> Unit
): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return label(icon = ImageIcon(url), block = block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.imageLabel(
    fileName: String,
    block: BasicScope<JLabel>.() -> Unit
): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return label(icon = ImageIcon(fileName), block = block)
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.imageLabel(
    bytes: ByteArray,
    block: BasicScope<JLabel>.() -> Unit
): JLabel {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return label(icon = ImageIcon(bytes), block = block)
}


//--

@OptIn(ExperimentalContracts::class)
fun CanAddChildrenScope<*>.imageLabel(
    icon: Icon? = null,
): JLabel = imageLabel(icon) {}

@OptIn(ExperimentalContracts::class)
fun CanAddChildrenScope<*>.imageLabel(
    url: URL,
): JLabel = imageLabel(url) {}


@OptIn(ExperimentalContracts::class)
fun CanAddChildrenScope<*>.imageLabel(
    fileName: String,
): JLabel = imageLabel(fileName) {}

@OptIn(ExperimentalContracts::class)
fun CanAddChildrenScope<*>.imageLabel(
    bytes: ByteArray,
): JLabel = imageLabel(bytes) {}

