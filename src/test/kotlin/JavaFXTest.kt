import io.github.mslxl.ktgui.common.fx
import io.github.mslxl.ktgui.common.swing
import io.github.mslxl.ktgui.ktfx.Scene
import io.github.mslxl.ktgui.ktfx.container.*
import io.github.mslxl.ktgui.ktfx.control.*
import io.github.mslxl.ktgui.ktswing.component.button
import io.github.mslxl.ktgui.ktswing.event.actionListener
import io.github.mslxl.ktgui.ktswing.layout.borderpanel
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Orientation
import javafx.scene.control.Alert
import javafx.stage.Stage
import javax.swing.JOptionPane

class JavaFXTest : Application() {
    val TEST_DATA_ITEM
        get() = FXCollections.observableArrayList<String>().apply {
            repeat(20) {
                add(it.toString())
            }
        }

    override fun start(stage: Stage) {
        stage.scene = Scene {
            borderPane {
                top {
                    menuBar {
                        prefWidthProperty().bind(stage.widthProperty())
                        menu("Menu"){
                            menuItem("MenuItem")
                            radioMenuItem("RadioMenuItem")
                            checkMenuItem("CheckMenuItem")
                            separator
                            menu("More"){
                                menuItem("hello,world")
                            }
                            separator
                            customMenuItem {
                                progressIndicator()
                            }
                        }
                        contextMenu = ContextMenu {
                            menu("Menu"){
                                menuItem("Hello")
                            }
                        }
                    }

                }
                center {
                    vBox {
                        menuBar()
                        accordion {
                            pane("Container") {
                                accordion {
                                    pane {
                                        isExpanded = true
                                        text = "BorderPane"
                                        borderPane {
                                            top {
                                                button("TOP")
                                            }
                                            center {
                                                button("CENTER")
                                            }
                                            bottom {
                                                button("BOTTOM")
                                            }
                                            left {
                                                button("LEFT")
                                            }
                                            right {
                                                button("RIGHT")
                                            }
                                        }
                                    }
                                    pane {
                                        text = "AnchorPane"
                                        anchorPane {
                                            button("AnchorPane")
                                        }
                                    }

                                    pane("ButtonBar") {
                                        buttonBar {
                                            button("0")
                                            button("1")
                                            button("2")
                                            button("3")
                                            button("4")
                                        }
                                    }
                                    pane("DialogPane") {
                                        dialogPane {
                                            header {
                                                button("header")
                                            }
                                            graphic {
                                                button("graphic")
                                            }
                                            content {
                                                button("content")
                                            }
                                            expandableContent {
                                                button("expandableContent")
                                            }
                                        }
                                    }
                                    pane("FlowPane") {
                                        flowPane {
                                            repeat(100) {
                                                button(it.toString())
                                            }
                                        }
                                    }
                                    pane("HBox") {
                                        hBox {
                                            repeat(10) {
                                                button(it.toString())
                                            }
                                        }
                                    }
                                    pane("Pane") {
                                        pane {
                                            button("Button") {
                                                layoutX = 60.0
                                                layoutY = 60.0
                                                rotate = 30.0
                                                setOnAction {
                                                    rotate += 10.0
                                                }
                                            }
                                        }
                                    }
                                    pane("ScrollPane") {
                                        scrollPane {
                                            flowPane {
                                                orientation = Orientation.VERTICAL
                                                repeat(500) {
                                                    button(it.toString())
                                                }
                                            }
                                        }
                                    }
                                    pane("SplitPane") {
                                        splitPane {
                                            orientation = Orientation.HORIZONTAL
                                            repeat(10) {
                                                button(it.toString())
                                            }
                                        }
                                    }
                                    pane("TabPane") {
                                        tabPane {
                                            repeat(3) {
                                                tab(it.toString()) {
                                                    button(it.toString())
                                                }
                                            }
                                        }
                                    }
                                    pane("VBox") {
                                        vBox {
                                            repeat(10) {
                                                button(it.toString())
                                            }
                                        }
                                    }
                                    pane("TilePane") {
                                        tilePane {
                                            repeat(500) {
                                                button(it.toString())
                                            }
                                        }
                                    }
                                    pane("ToolBar") {
                                        toolBar {
                                            repeat(6) {
                                                button(it.toString())
                                            }
                                        }
                                    }
                                }
                            }
                            pane("Control") {
                                scrollPane {
                                    vBox {
                                        label("hello,world")
                                        hBox {
                                            hyperlink("mslxl") {
                                                setOnAction {
                                                    imageView("https://avatars3.githubusercontent.com/u/11132880?s=460&v=4")
                                                }
                                            }
                                        }
                                        button("Button")
                                        checkBox("CheckBox")
                                        choiceBox<String> {
                                            items = TEST_DATA_ITEM
                                            selectionModel.selectFirst()
                                        }
                                        colorPicker()
                                        comboBox<String> {
                                            items = TEST_DATA_ITEM
                                            selectionModel.selectFirst()
                                        }
                                        datePicker()
                                        scrollPane {
                                            prefHeight = 180.toDouble()
                                            htmlEditor()
                                        }

                                        menuButton {
                                            //TODO
                                        }
                                        pagination {
                                            prefHeight = 180.toDouble()
                                            prefWidth = 180.toDouble()
                                        }
                                        passwordField()
                                        progressBar()
                                        progressIndicator()
                                        radioButton("RadioButton")
                                        scrollBar()
                                        separator
                                        slider()
                                        listView<String> {
                                            items = TEST_DATA_ITEM
                                        }
                                        splitMenuButton()
                                        textField()
                                        textArea()
                                        toggleButton("ToggleButton")

                                        treeTableView<String>()
                                        tableView<String>()
                                        treeView<String>()
                                    }
                                }
                                pane("Github") {
                                    webView {
                                        engine.load("https://github.com/mslxl")
                                    }
                                }
                                pane("Swing") {
                                    stackPane {
                                        swing {
                                            borderpanel {
                                                west {
                                                    button("JButton") {
                                                        actionListener {
                                                            JOptionPane.showMessageDialog(null, "JButton")
                                                        }
                                                    }
                                                }
                                                east {
                                                    fx {
                                                        button("Button") {
                                                            setOnAction {
                                                                Alert(Alert.AlertType.INFORMATION, "Button").show()
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }

        }
        stage.width = 500.toDouble()
        stage.height = 600.toDouble()
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(JavaFXTest::class.java, *args)
        }
    }
}