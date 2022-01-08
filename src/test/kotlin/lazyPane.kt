import io.github.mslxl.ktswing.attr
import io.github.mslxl.ktswing.component.adv.lazyPanel
import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.label
import io.github.mslxl.ktswing.component.tabbedPane
import io.github.mslxl.ktswing.defaultLayout
import io.github.mslxl.ktswing.exitOnClose
import io.github.mslxl.ktswing.frame

fun main() = frame {
    attr {
        setSize(400, 300)
    }

    defaultLayout {
        tabbedPane {
            tab("Default Tab") {
                defaultLayout {
                    label("Consumed 500 ms per tab when it was created firstly")
                }
            }
            repeat(10) { num ->

                tab("Lazy Tab $num") {
                    defaultLayout {
                        lazyPanel {
                            println("Lazy pane $num init")
                            defaultLayout {
                                Thread.sleep(5 * 100)
                                button("Consumed 500 ms per tab when it was created firstly")
                            }
                        }
                    }
                }
            }
        }
    }

}.exitOnClose
