import io.github.mslxl.ktswing.attr
import io.github.mslxl.ktswing.component.adv.lazyPanelWith
import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.label
import io.github.mslxl.ktswing.component.tabbedPane
import io.github.mslxl.ktswing.defaultLayout
import io.github.mslxl.ktswing.exitOnClose
import io.github.mslxl.ktswing.frame
import io.github.mslxl.ktswing.layout.borderLayoutCenter

fun main() = frame {
    attr {
        setSize(400, 300)
    }

    defaultLayout {
        tabbedPane {
            tabPanel("Default Tab") {
                defaultLayout {
                    label("Consumed 500 ms per tab when it was created firstly")
                }
            }
            repeat(10) { num ->

                tabPanelWith("Lazy Tab $num", borderLayoutCenter()) {
                    lazyPanelWith(borderLayoutCenter()) {
                        println("Lazy pane $num init")
                        Thread.sleep(5 * 100)
                        button("Consumed 500 ms per tab when it was created firstly")
                    }
                }
            }
        }
    }

}.exitOnClose
