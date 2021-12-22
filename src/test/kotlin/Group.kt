import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.panel
import io.github.mslxl.ktswing.component.textArea
import io.github.mslxl.ktswing.component.textField
import io.github.mslxl.ktswing.exitOnClose
import io.github.mslxl.ktswing.frame
import io.github.mslxl.ktswing.group.swing
import io.github.mslxl.ktswing.layout.borderLayout
import io.github.mslxl.ktswing.withH
import io.github.mslxl.ktswing.withW
import javax.swing.JPanel
import javax.swing.border.TitledBorder


fun searchBar() = swing<JPanel> {
    attr {
        border = TitledBorder("Search")
    }
    borderLayout {
        center {
            textField()
        }
        right {
            button("Search")
        }
    }
}

fun main() =
    frame {
        attr {
            title = "Sample"
            bounds = bounds.withH(400).withW(500)
        }
        borderLayout {
            top {
                panel(searchBar().initBlock)
            }
            center {
                textArea()
            }
        }
    }.exitOnClose