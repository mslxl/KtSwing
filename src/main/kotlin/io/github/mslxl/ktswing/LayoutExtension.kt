
package io.github.mslxl.ktswing.layout

import io.github.mslxl.ktswing.Content
import io.github.mslxl.ktswing.EndCallback
import io.github.mslxl.ktswing.__ktswing
import io.github.mslxl.ktswing._createContent
import java.awt.*
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JComponent
import javax.swing.JPanel

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
/**
 * See [gridlayout]
 */
class _GridLayout : BasePanel(), EndCallback {
    override fun _endCallBack() {
        updateLayout()
    }

    fun updateLayout(){
        (layout as GridLayout).columns = _cols
        _comps.forEach {
            row->
            row.forEach {
                add(it)
            }
            repeat(_cols-row.size){
                gap()
            }
        }
        // println("${(layout as GridLayout).rows} X ${(layout as GridLayout).columns}")
    }
    var _firstRowInserted = false
    var _cols = 0
    var _comps = ArrayList<ArrayList<JComponent>>()

    var hgap:Int
        set(value) {
            (layout as GridLayout).hgap = value
        }
        get() = (layout as GridLayout).hgap
    var vgap:Int
        set(value) {
            (layout as GridLayout).vgap = value
        }
        get() = (layout as GridLayout).vgap

    init {
        layout = GridLayout()
    }

    fun gap() {
        add(Box.createHorizontalStrut(0))
    }

    /**
     * Add [JComponent] row
     *
     * 添加 [JComponent] 行
     */
    inline fun row(code:Content.()->Unit){
        if (_firstRowInserted)
            (layout as GridLayout).rows++
        val colList = ArrayList<JComponent>()
        code.invoke(_createContent {
            colList.add(it)
        })
        _comps.add(colList)
        if (colList.size > _cols){
            _cols = colList.size
        }
        _firstRowInserted = true
    }
}

/**
 * Create a [JPanel] with [GridLayout]
 * You can use [_GridLayout.row] to add [JComponent] row
 *
 * 创建一个使用 [GridLayout] 的 [JPanel]
 * 你可以使用 [_GridLayout.row] 方法来添加 [JComponent] 行
 */
inline fun Content.gridlayout(init: _GridLayout.() -> Unit): JPanel = __ktswing(_GridLayout(), this, init)


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

class _AabsoluteLayout : BasePanel(),Content {
    override fun onAddToContent(comp: JComponent) {
        this.add(comp)
    }
    init {
        layout = null
    }
}

inline fun Content.absolutepanel(init: _AabsoluteLayout.() -> Unit): JPanel = __ktswing(_AabsoluteLayout(), this, init)


