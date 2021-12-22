import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.component.button
import kotlin.system.exitProcess

fun main() = frame {
    attr {
        title = "Sample"
        bounds = bounds.withW(300).withH(200)
    }
    defaultLayout {
        button("Hello World") {
            onAction {
                exitProcess(0)
            }
        }
    }
}.exitOnClose