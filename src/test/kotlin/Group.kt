import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.panel
import io.github.mslxl.ktswing.component.textArea
import io.github.mslxl.ktswing.component.textField
import io.github.mslxl.ktswing.group.swing
import io.github.mslxl.ktswing.layout.borderLayout
import javax.swing.JPanel
import javax.swing.border.TitledBorder


fun searchBar() = swing<JPanel> {
    panel {
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
}

fun main() =
    frame {
        attr {
            title = "Sample"
            bounds = bounds.withH(400).withW(500)
        }
        borderLayout {
            top {
                add(searchBar())
            }
            center {
                textArea()
            }
        }
    }.exitOnClose
