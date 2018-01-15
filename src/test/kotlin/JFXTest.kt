import io.github.mslxl.ktgui.ktfx.Scene
import io.github.mslxl.ktgui.ktfx.container.vBox
import io.github.mslxl.ktgui.ktfx.control.label
import io.github.mslxl.ktgui.ktfx.foenix.*
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.stage.Stage

class JFXTest : Application() {
    internal operator fun String.times(times: Int) = buildString {
        kotlin.repeat(times) {
            append(this@times)
        }
    }

    override fun start(stage: Stage) {
        stage.scene = Scene {
            jfxTabPane {
                tab("Page 1") {
                    println(this)
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
                    vBox {
                        jfxToggleButton()
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