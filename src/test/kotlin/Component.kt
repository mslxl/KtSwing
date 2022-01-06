import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.component.*
import io.github.mslxl.ktswing.layout.borderLayout
import io.github.mslxl.ktswing.layout.flowLayout
import javax.swing.ButtonGroup
import javax.swing.border.TitledBorder

fun main() = frame {
    attr {
        title = "Sample"
        bounds = bounds.withH(400).withW(500)
    }
    menuBar {
        menu("File") {
            menu("New") {
                item("File")
                item("Directory")
            }
            separator
            item("Close")
            separator
            checkItem("Add BOM head")
            separator
            val group = ButtonGroup()
            menu("Power Save Mode") {
                radioItem("On", group = group)
                radioItem("Off", group = group)
            }
        }
        menu("Edit") {}
        menu("View") {}
    }

    defaultLayout {
        tabbedPane {
            tab("Basic"){
                flowLayout {
                    button("Button")
                    checkBox("CheckBox")
                    textArea(text = "TextArea")
                    textField(text = "TextField")
                    passwordField(password = "3.141592653")
                    panel {
                        attr {
                            border = TitledBorder("RadioButton")
                        }
                        flowLayout {
                            val btnGroup = ButtonGroup()
                            radioButton(text = "Option 1", group = btnGroup)
                            radioButton(text = "Option 2", group = btnGroup)
                            radioButton(text = "Option 3", group = btnGroup)
                        }
                    }
                    toggleButton("ToggleButton")
                    progressBar(min = 0, max = 100) {
                        attr {
                            value = 50
                        }
                    }
                    slider(1, min = 0, max = 100)
                    scrollbar(1)
                    scrollPane {
                        list((1..50).map { "Item $it" })
                    }
                    comboBox((1..10).map { "Item $it" })
                }
            }
            tab("Second"){
                borderLayout {
                    top{
                        label("2nd Tab")
                    }
                }
            }
        }

    }
}.exitOnClose

