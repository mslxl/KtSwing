import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.component.button
import io.github.mslxl.ktswing.component.label
import io.github.mslxl.ktswing.component.panelWith
import io.github.mslxl.ktswing.layout.borderLayout
import io.github.mslxl.ktswing.layout.gridLayout
import kotlin.system.exitProcess

fun main() {
    frame {
        exitOnClose
        self.bounds = self.bounds.withW(400).withH(400)
        borderLayout {
            center {
                panelWith(gridLayout(5,5)) {
                    row {
                        button("r1c1")
                        button("r1c2")
                    }
                    row{
                        button("r2c1")
                        button("r2c2")
                    }
                }
            }

            left {
                label("This is left")
            }
            right {
                label("This is right")
            }

            top {
                button("Exit") {
                    onAction {
                        exitProcess(0)
                    }
                }
            }
            bottom {
                var times = Int.MAX_VALUE - 2
                button("Click me") {
                    onAction {
                        times++
                        self.text = "$times times"
                    }
                }
            }
        }
    }
}