package io.github.mslxl.ktswing

import java.awt.*
import javax.swing.*



// FlowLayout
class _FlowLayout : JPanel(), Content {
    init {
        layout = FlowLayout()

    }
}

inline fun Container.flowpanel(init: _FlowLayout.() -> Unit): JPanel = _FlowLayout().apply {
    this@flowpanel.add(this)

}.apply(init)


// BorderLayout
class _BorderLayout : JPanel() {
    init {
        layout = BorderLayout()
    }

    inline fun north(init: Content.() -> Unit) {
        _createContent { this.add(it, BorderLayout.NORTH) }.apply(init)
    }

    inline fun south(init: Content.() -> Unit) {
        _createContent { this.add(it, BorderLayout.SOUTH) }.apply(init)
    }

    inline fun west(init: Content.() -> Unit) {
        _createContent { this.add(it, BorderLayout.WEST) }.apply(init)
    }

    inline fun east(init: Content.() -> Unit) {
        _createContent { this.add(it, BorderLayout.EAST) }.apply(init)
    }

    inline fun centre(init: Content.() -> Unit) {
        _createContent { this.add(it, BorderLayout.CENTER) }.apply(init)
    }
}

inline fun Container.borderpanel(init: _BorderLayout.() -> Unit): JPanel = _BorderLayout().apply {
    this@borderpanel.add(this)
}.apply(init)

// GridLayout
class _GridLayout(val rows: Int, val cols: Int, val hgap: Int, val vgap: Int) : JPanel(), Content {
    init {
        layout = GridLayout(rows, cols, hgap, vgap)
    }
    fun empty(){
        add(Box.createHorizontalStrut(0))
    }
}

inline fun Container.gridlayout(rows: Int = 1, cols: Int = 0, hgap: Int = 0, vgap: Int = 0, init: _GridLayout.() -> Unit): JPanel = _GridLayout(rows, cols, hgap, vgap).apply {
    this@gridlayout.add(this)
}.apply(init)


// GridBagLayout
class _GridBaglayout() : JPanel() {
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
inline fun Container.gridbagpanel(init:_GridBaglayout.()->Unit):JPanel = _GridBaglayout().apply {
    this@gridbagpanel.add(this)
}.apply(init)
enum class AXIS{
    X_AXIS,Y_AXIS,LINE_AXIS,PAGE_AXIS
}

// BoxLayout
class _BoxLayout(axis: AXIS):JPanel(),Content{
    init {
        layout = BoxLayout(this,when(axis){
            AXIS.X_AXIS->0
            AXIS.Y_AXIS->1
            AXIS.LINE_AXIS->2
            AXIS.PAGE_AXIS->3
        })
    }
}
inline fun Container.boxpanel(axis: AXIS = AXIS.X_AXIS, init:_BoxLayout.()->Unit):JPanel = _BoxLayout(axis).apply { this@boxpanel.add(this) }.apply(init)

// CardLayout
class _CardLayout:JPanel(),Content{
    init {
        layout = CardLayout()
    }
}

inline fun Container.cardpanel(init:_CardLayout.()->Unit):JPanel = _CardLayout().apply { this@cardpanel.add(this) }.apply(init)

class _AabsoluteLayout:JPanel(){
    init {
        layout = null
    }
    inline fun at(init: Content.() -> Unit){
        _createContent {
            this.add(it)
        }.apply(init)
    }
}
inline fun Container.absolutepanel(init: _AabsoluteLayout.() -> Unit):JPanel = _AabsoluteLayout().apply { this@absolutepanel.add(this) }.apply(init)