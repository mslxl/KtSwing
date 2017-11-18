package io.github.mslxl.ktswing

import java.awt.*
import javax.swing.*

open class BasePanel : JPanel(), Content

fun __ktswingPanelAdd(panel: BasePanel, container: Container) {
    if (container is JFrame) {
        container.contentPane = panel
    } else {
        container.add(panel)
    }
}

inline fun <F : BasePanel> __ktswingPanel(panel: F, container: Container, init: F.() -> Unit): F {
    __ktswingPanelAdd(panel, container)
    init.invoke(panel)
    return panel
}

// FlowLayout
class _FlowLayout : BasePanel(), Content {
    init {
        layout = FlowLayout()

    }
}

inline fun Container.flowpanel(init: _FlowLayout.() -> Unit): JPanel = __ktswingPanel(_FlowLayout(), this, init)


// BorderLayout
class _BorderLayout : BasePanel() {
    init {
        layout = BorderLayout()
    }

    val northAddMethod = _createContent { this.add(it, BorderLayout.NORTH) }
    val southAddMethod = _createContent { this.add(it, BorderLayout.SOUTH) }
    val westAddMethod = _createContent { this.add(it, BorderLayout.WEST) }
    val centreAddMethod = _createContent { this.add(it, BorderLayout.CENTER) }
    val eastAddMethod = _createContent { this.add(it, BorderLayout.EAST) }
    inline fun north(init: Content.() -> Unit) {
        northAddMethod.apply(init)
    }

    inline fun south(init: Content.() -> Unit) {
        southAddMethod.apply(init)
    }

    inline fun west(init: Content.() -> Unit) {
        westAddMethod.apply(init)
    }

    inline fun east(init: Content.() -> Unit) {
        eastAddMethod.apply(init)
    }

    inline fun centre(init: Content.() -> Unit) {
        centreAddMethod.apply(init)
    }
}

inline fun Container.borderpanel(init: _BorderLayout.() -> Unit): JPanel = __ktswingPanel(_BorderLayout(), this, init)

// GridLayout
class _GridLayout(val rows: Int, val cols: Int, val hgap: Int, val vgap: Int) : BasePanel(), Content {
    init {
        layout = GridLayout(rows, cols, hgap, vgap)
    }

    fun empty() {
        add(Box.createHorizontalStrut(0))
    }
}

inline fun Container.gridlayout(rows: Int = 1, cols: Int = 0, hgap: Int = 0, vgap: Int = 0, init: _GridLayout.() -> Unit): JPanel = __ktswingPanel(_GridLayout(rows, cols, hgap, vgap), this, init)


// GridBagLayout
class _GridBaglayout() : BasePanel() {
    init {
        layout = GridBagLayout()
    }

    //  int anchor, int fill, Insets insets, int ipadx, int ipady
    inline fun constraints(gridX: Int = GridBagConstraints.RELATIVE,
                           gridY: Int = GridBagConstraints.RELATIVE,
                           gridWidth: Int = 1,
                           gridHeight: Int = 1,
                           weightX: Double = 0.0,
                           weightY: Double = 0.0,
                           anchor: Int = GridBagConstraints.CENTER,
                           fill: Int = GridBagConstraints.NONE,
                           insets: Insets = Insets(0, 0, 0, 0),
                           ipadX: Int = 0,
                           ipadY: Int = 0,
                           init: Content.() -> Unit) {
        _createContent { this.add(it, GridBagConstraints(gridX, gridY, gridWidth, gridHeight, weightX, weightY, anchor, fill, insets, ipadX, ipadY)) }.apply(init)
    }
}

inline fun Container.gridbagpanel(init: _GridBaglayout.() -> Unit): JPanel = __ktswingPanel(_GridBaglayout(), this, init)

// BoxLayout
class _BoxLayout(axis: AXIS) : BasePanel(), Content {
    init {
        layout = BoxLayout(this, when (axis) {
            AXIS.X_AXIS -> 0
            AXIS.Y_AXIS -> 1
            AXIS.LINE_AXIS -> 2
            AXIS.PAGE_AXIS -> 3
        })
    }
}

enum class AXIS {
    X_AXIS, Y_AXIS, LINE_AXIS, PAGE_AXIS
}

inline fun Container.boxpanel(axis: AXIS = AXIS.X_AXIS, init: _BoxLayout.() -> Unit): JPanel = __ktswingPanel(_BoxLayout(axis), this, init)

// CardLayout
class _CardLayout : BasePanel(), Content {
    init {
        layout = CardLayout()
    }
}

inline fun Container.cardpanel(init: _CardLayout.() -> Unit): JPanel = __ktswingPanel(_CardLayout(), this, init)

class _AabsoluteLayout : BasePanel() {
    val addMethod = _createContent {
        this.add(it)
    }

    init {
        layout = null
    }

    inline fun at(init: Content.() -> Unit) {
        addMethod.apply(init)
    }
}

inline fun Container.absolutepanel(init: _AabsoluteLayout.() -> Unit): JPanel = __ktswingPanel(_AabsoluteLayout(), this, init)