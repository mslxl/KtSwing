import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.panel
import io.github.mslxl.ktswing.exitOnClose
import io.github.mslxl.ktswing.frame
import io.github.mslxl.ktswing.layout.borderLayout
import io.github.mslxl.ktswing.layout.cardLayout
import io.github.mslxl.ktswing.layout.flowLayout
import java.awt.CardLayout
import javax.swing.JPanel

fun main() = frame {
    attr {
        setSize(800, 600)
    }
    borderLayout {
        var pane: JPanel
        var layout: CardLayout
        center {
            panel {
                pane = self
                layout = cardLayout {
                    card("1") {
                        button("1")
                    }
                    card("2") {
                        button("2")
                    }
                }
            }
        }
        top {
            panel{
                flowLayout {
                    button("1").addActionListener {
                        layout.show(pane, "1")
                    }
                    button("2").addActionListener {
                        layout.show(pane, "2")
                    }
                }
            }
        }
    }
}.exitOnClose

