import io.github.mslxl.ktswing.attr
import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.split2Pane
import io.github.mslxl.ktswing.component.splitPane
import io.github.mslxl.ktswing.defaultLayout
import io.github.mslxl.ktswing.exitOnClose
import io.github.mslxl.ktswing.frame
import javax.swing.JSplitPane

fun main() = frame {
    attr {
        setSize(400, 300)
    }

    defaultLayout {
        split2Pane(newOrient = JSplitPane.VERTICAL_SPLIT) {
            top {
                button("Top")
            }
            bottom {
                splitPane {
                    allSplitPane {
                        it.dividerSize = 1
                    }
                    repeat(5) {
                        button(it.toString())
                    }
                }
            }
        }
    }

}.exitOnClose

