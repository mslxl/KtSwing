package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.BasicScope
import io.github.mslxl.ktswing.CanAddChildrenScope
import io.github.mslxl.ktswing.NeedUpdate
import java.awt.Component
import javax.swing.JSplitPane
import javax.swing.UIManager
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class JSplitPane2PartScope(override val self: JSplitPane, private val isLeft: Boolean) :
    CanAddChildrenScope<JSplitPane> {
    override fun add(component: Component) {
        if (isLeft)
            self.leftComponent = component
        else
            self.rightComponent = component
    }
}

class JSplitPane2Scope(override val self: JSplitPane) : BasicScope<JSplitPane> {
    @OptIn(ExperimentalContracts::class)
    inline fun left(block: JSplitPane2PartScope.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        JSplitPane2PartScope(self, true).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun right(block: JSplitPane2PartScope.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        JSplitPane2PartScope(self, false).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun top(block: JSplitPane2PartScope.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        JSplitPane2PartScope(self, true).apply(block)
    }

    @OptIn(ExperimentalContracts::class)
    inline fun bottom(block: JSplitPane2PartScope.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        JSplitPane2PartScope(self, false).apply(block)
    }
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.split2Pane(
    newOrient: Int = JSplitPane.HORIZONTAL_SPLIT,
    newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
    block: JSplitPane2Scope.() -> Unit
): JSplitPane {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val scope = JSplitPane2Scope(JSplitPane(newOrient, newContinuousLayout)).apply(block)
    add(scope.self)
    return scope.self
}

class JSplitPaneMoreScope(
    private val newOrient: Int = JSplitPane.HORIZONTAL_SPLIT,
    private val newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
) : CanAddChildrenScope<JSplitPane>, NeedUpdate {
    override val self = JSplitPane(newOrient, newContinuousLayout)
    private val components = arrayListOf<Component>()
    private var allSplitPane: ((JSplitPane) -> Unit)? = null
    override fun add(component: Component) {
        components.add(component)
    }

    fun allSplitPane(block: (JSplitPane) -> Unit) {
        allSplitPane = block
    }

    override fun update() {
        components.foldIndexed(self) { index: Int, splitPane: JSplitPane, comp: Component ->
            if (index == 0) {
                // First one
                splitPane.leftComponent = comp
                splitPane
            } else if (index < components.size - 1) {
                // Not last one
                val newSplitPane = JSplitPane(newOrient)
                splitPane.rightComponent = newSplitPane
                newSplitPane.leftComponent = comp

                allSplitPane?.invoke(splitPane)

                newSplitPane
            } else {
                // Last one
                splitPane.rightComponent = comp
                allSplitPane?.invoke(splitPane)
                splitPane
            }
        }
    }
}


@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.splitPane(
    newOrient: Int = JSplitPane.HORIZONTAL_SPLIT,
    newContinuousLayout: Boolean = UIManager.getBoolean("SplitPane.continuousLayout"),
    block: JSplitPaneMoreScope.() -> Unit
): JSplitPane {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val scope = JSplitPaneMoreScope(newOrient, newContinuousLayout).apply(block)
    scope.update()
    add(scope.self)
    return scope.self
}
