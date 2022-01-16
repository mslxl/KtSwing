import io.github.mslxl.ktswing.attr
import io.github.mslxl.ktswing.component.*
import io.github.mslxl.ktswing.exitOnClose
import io.github.mslxl.ktswing.frame
import io.github.mslxl.ktswing.layout.flowLayout
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JButton

fun main() = frame {
    attr {
        size = Dimension(300, 400)
    }
    flowLayout {
        button("Show popup").addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                (e.source as JButton).showPopupMenu(e.x, e.y) {
                    item("Item 1")
                    menu("Menu") {
                        item("Item 2")
                        separator
                        checkItem("Check")
                    }
                }
            }
        })
    }
}.exitOnClose

