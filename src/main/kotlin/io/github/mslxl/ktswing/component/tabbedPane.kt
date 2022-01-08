package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.group.SwingComponentBuilderScope
import io.github.mslxl.ktswing.group.swing
import io.github.mslxl.ktswing.layout.LayoutScopeWrapper
import java.awt.Component
import javax.swing.JPanel
import javax.swing.JTabbedPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class TabbedPaneScope(override val self: JTabbedPane) : BasicScope<JTabbedPane> {
    @OptIn(ExperimentalContracts::class)
    fun tab(name: String, block: SwingComponentBuilderScope<Component>.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        self.add(name, swing {
            this.apply(block)
        })
    }

    @OptIn(ExperimentalContracts::class)
    fun tabPanel(name: String, block: CanSetLayoutScope<JPanel>.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        self.add(name, swing {
            panel(block)
        })
    }

    @OptIn(ExperimentalContracts::class)
    fun <L : LayoutScope> tabPanelWith(
        name: String,
        layoutScope: LayoutScopeWrapper<JPanel, L>,
        panel: JPanel = JPanel(),
        block: L.() -> Unit
    ) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        val scope = layoutScope.invoke(panel).apply(block)
        if (scope is NeedUpdate) scope.update()
        self.add(name, swing {
            add(panel)
        })
    }
}

@OptIn(ExperimentalContracts::class)
inline fun CanAddChildrenScope<*>.tabbedPane(
    tabPlacement: Int = JTabbedPane.TOP,
    tabLayoutPolicy: Int = JTabbedPane.WRAP_TAB_LAYOUT,
    block: TabbedPaneScope.() -> Unit
): JTabbedPane {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val pane = JTabbedPane(tabPlacement, tabLayoutPolicy)
    TabbedPaneScope(pane).apply(block)
    add(pane)
    return pane
}