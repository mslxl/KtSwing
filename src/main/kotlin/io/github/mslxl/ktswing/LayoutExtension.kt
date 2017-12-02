package io.github.mslxl.ktswing

import java.awt.*
import javax.swing.*

open class BasePanel : JPanel()


// FlowLayout
class _FlowLayout : BasePanel(), Content {
    override fun onAddToContent(comp: JComponent) {
        add(comp)
    }

    init {
        layout = FlowLayout()
    }
}

inline fun Content.flowpanel(init: _FlowLayout.() -> Unit): JPanel = __ktswing(_FlowLayout(), this, init)


// BorderLayout
class _BorderLayout : BasePanel() {
    init {
        layout = BorderLayout()
    }

    val _northAddMethod = _createContent {
        this.add(it, BorderLayout.NORTH) }
    val _southAddMethod = _createContent {
        this.add(it, BorderLayout.SOUTH) }
    val _westAddMethod = _createContent {
        this.add(it, BorderLayout.WEST) }
    val _centreAddMethod = _createContent {
        this.add(it, BorderLayout.CENTER)
    }
    val _eastAddMethod = _createContent {
        this.add(it, BorderLayout.EAST) }

    inline fun north(init: Content.() -> Unit) {
        _northAddMethod.apply(init)
    }

    inline fun south(init: Content.() -> Unit) {
        _southAddMethod.apply(init)
    }

    inline fun west(init: Content.() -> Unit) {
        _westAddMethod.apply(init)
    }

    inline fun east(init: Content.() -> Unit) {
        _eastAddMethod.apply(init)
    }

    inline fun centre(init: Content.() -> Unit) {
        _centreAddMethod.apply(init)
    }
}

inline fun Content.borderpanel(init: _BorderLayout.() -> Unit): JPanel = __ktswing(_BorderLayout(), this, init)

// GridLayout
class _GridLayout(rows: Int, cols: Int, hgap: Int, vgap: Int) : BasePanel(), Content {
    override fun onAddToContent(comp: JComponent) {
        add(comp)
    }

    init {
        layout = GridLayout(rows, cols, hgap, vgap)
    }

    fun empty() {
        add(Box.createHorizontalStrut(0))
    }
}

inline fun Content.gridlayout(rows: Int = 1, cols: Int = 0, hgap: Int = 0, vgap: Int = 0, init: _GridLayout.() -> Unit): JPanel = __ktswing(_GridLayout(rows, cols, hgap, vgap), this, init)


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

inline fun Content.gridbagpanel(init: _GridBaglayout.() -> Unit): JPanel = __ktswing(_GridBaglayout(), this, init)

// BoxLayout
class _BoxLayout(axis: AXIS) : BasePanel(), Content {
    override fun onAddToContent(comp: JComponent) {
        add(comp)
    }

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

inline fun Content.boxpanel(axis: AXIS = AXIS.X_AXIS, init: _BoxLayout.() -> Unit): JPanel = __ktswing(_BoxLayout(axis), this, init)

// CardLayout
class _CardLayout : BasePanel(), Content {
    override fun onAddToContent(comp: JComponent){
        add(comp)
    }

    init {
        layout = CardLayout()
    }
}

inline fun Content.cardpanel(init: _CardLayout.() -> Unit): JPanel = __ktswing(_CardLayout(), this, init)

class _AabsoluteLayout : BasePanel() {
    val _addMethod = _createContent {
        this.add(it)
    }

    init {
        layout = null
    }

    inline fun at(init: Content.() -> Unit) {
        _addMethod.apply(init)
    }
}

inline fun Content.absolutepanel(init: _AabsoluteLayout.() -> Unit): JPanel = __ktswing(_AabsoluteLayout(), this, init)


