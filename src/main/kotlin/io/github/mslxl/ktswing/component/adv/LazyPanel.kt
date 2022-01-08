package io.github.mslxl.ktswing.component.adv

import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.CanSetLayoutScope
import java.awt.Graphics
import javax.swing.JPanel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class LazyPanel(
    private var initializer: ((LazyPanel) -> Unit)?
) : JPanel() {
    override fun paint(g: Graphics?) {
        initializer?.let {
            it.invoke(this)
            initializer = null
            this.updateUI()
        }
        super.paint(g)
    }
}


@OptIn(ExperimentalContracts::class)
fun CanAddChildrenScope<*>.lazyPanel(block: CanSetLayoutScope<LazyPanel>.() -> Unit): LazyPanel {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    val pane = LazyPanel {
        CanSetLayoutScope(it).apply(block)
    }
    add(pane)
    return pane
}