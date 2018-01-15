@file:JvmName("Layout")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktswing.layout

import io.github.mslxl.ktgui.common.EndCallback
import io.github.mslxl.ktgui.ktswing.SwingPanelNode
import io.github.mslxl.ktgui.ktswing._createSwingPanelNode
import io.github.mslxl.ktgui.ktswing._ktswing
import io.github.mslxl.ktgui.ktswing.component.BasePanel
import java.awt.GridLayout
import javax.swing.Box
import javax.swing.JComponent
import javax.swing.JPanel

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
    inline fun row(code: SwingPanelNode.()->Unit){
        if (_firstRowInserted)
            (layout as GridLayout).rows++
        val colList = ArrayList<JComponent>()
        code.invoke(_createSwingPanelNode {
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
inline fun SwingPanelNode.gridlayout(init: _GridLayout.() -> Unit): JPanel = _ktswing(_GridLayout(), init)