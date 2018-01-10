import io.github.mslxl.ktgui.ktswing.component.*
import io.github.mslxl.ktgui.ktswing.event.actionListener
import io.github.mslxl.ktgui.ktswing.exitOnClose
import io.github.mslxl.ktgui.ktswing.frame
import io.github.mslxl.ktgui.ktswing.layout.borderpanel
import io.github.mslxl.ktgui.ktswing.layout.flowpanel
import io.github.mslxl.ktgui.ktswing.resizable
import io.github.mslxl.ktgui.ktswing.size
import javax.swing.JFrame
import javax.swing.SwingConstants.CENTER

lateinit var frame:JFrame
fun main(args: Array<String>) {
    frame = frame("Notepad") {
        exitOnClose
        resizable
        size {
            width = 500
            height = 400
        }
        menubar {
            menu("File"){
                menuItem("Open")
                menuItem("Save")
                separator
                menuItem("Exit")
            }
            menu("Settings"){
                menuItem("Font")
            }
        }

        borderpanel {
            north {
                label("File not open"){
                    horizontalAlignment = CENTER
                }
            }
            centre {
                scrollPane {
                    textarea {
                        name = "textarea"
                        text = "Editor"
                    }
                }
            }
            south {
                flowpanel {
                    name = "flow"
                    button("Ok"){
                        actionListener {
                            frame.dispose()
                        }
                    }
                }
            }
        }
    }
}