import io.github.mslxl.ktswing.*
import javax.swing.SwingConstants.CENTER

fun main(args: Array<String>) {
    frame("Notepad") {
        disposeOnClose
        resizable
        size {
            width = 500
            height = 400
        }
        menubar {
            menu("File"){
                menuItem("Open")
                separator
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
                    button("Ok"){
                        actionListener {
                            dispose()
                        }
                    }
                }
            }
        }
    }
}