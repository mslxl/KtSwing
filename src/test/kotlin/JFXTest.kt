import io.github.mslxl.ktgui.ktfx.FxUI
import io.github.mslxl.ktgui.ktfx.container.hBox
import io.github.mslxl.ktgui.ktfx.container.stackPane
import io.github.mslxl.ktgui.ktfx.container.vBox
import io.github.mslxl.ktgui.ktfx.control.label
import io.github.mslxl.ktgui.ktfx.createScene
import io.github.mslxl.ktgui.ktfx.jfoenix.*

import javafx.application.Application
import javafx.collections.FXCollections
import javafx.scene.control.Label
import javafx.stage.Stage


class JFXTest : Application() {
    internal operator fun String.times(times: Int) = buildString {
        kotlin.repeat(times) {
            append(this@times)
        }
    }

    override fun start(stage: Stage) {
        stage.scene = stage.createScene {
            //decorator {
            jfxTabPane {
                tab("Page 1") {
                    vBox {
                        spacing = 20.0
                        jfxRippler {
                            label("AAA" * 40)
                        }
                        jfxButton("jfxButton")
                        jfxCheckBox("jfxCheckBox")
                        jfxComboBox<String> {
                            items = TEST_DATA_ITEM
                            selectionModel.selectFirst()
                        }
                        jfxHamburger()
                        jfxTextField {
                            text = "JFXTextField"
                            isLabelFloat = true
                            promptText = "Deep Dark Fantasy"
                        }
                        jfxRadioButton("jfxRadioButton")
                        jfxProgressBar()
                        jfxSlider()
                    }
                }
                tab("Page 2") {
                    stackPane {
                        vBox {
                            val stc = stackPane { }
                            spacing = 20.0
                            jfxToggleButton()
                            jfxDatePicker()
                            jfxListView<String>()
                            jfxButton("Dialog") {
                                setOnAction {
                                    jfxDialog {
                                        this.content = FxUI {
                                            vBox {
                                                spacing = 40.0
                                                label("Deep Dark Fantasy")
                                                hBox {
                                                    spacing = 20.0
                                                    jfxButton("Yes")
                                                    jfxButton("No")
                                                }
                                            }
                                        }.region
                                        this.dialogContainer = this@stackPane
                                    }.show()
                                }
                            }
                            val drawer = jfxDrawer {
                                setSidePane(stc)
                                setContent(Label("aaaa"))
                            }
                            jfxButton("Drawer") {
                                setOnAction {
                                    drawer.toggle()
                                }
                            }

                            //}
                        }
                    }
                }
            }
        }
        stage.show()
        stage.width = 400.0
    }

    val TEST_DATA_ITEM
        get() = FXCollections.observableArrayList<String>().apply {
            repeat(20) {
                add(it.toString())
            }
        }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(JFXTest::class.java, *args)
        }
    }
}