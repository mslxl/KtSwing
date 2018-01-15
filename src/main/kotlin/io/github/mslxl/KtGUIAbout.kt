@file:JvmName("KtGUIMain")
@file:JvmMultifileClass

package io.github.mslxl

import io.github.mslxl.ktgui.ktfx.Scene
import io.github.mslxl.ktgui.ktfx.container.borderPane
import io.github.mslxl.ktgui.ktfx.control.webView
import io.github.mslxl.ktgui.ktfx.menu.menu
import io.github.mslxl.ktgui.ktfx.menu.menuBar
import io.github.mslxl.ktgui.ktfx.menu.menuItem
import javafx.application.Application
import javafx.stage.Stage

class KtGUIAbout : Application() {
    override fun start(stage: Stage) {
        stage.scene = Scene {
            borderPane {
                top {
                    menuBar {
                        menu("Action") {
                            menuItem("Exit") {
                                setOnAction {
                                    System.exit(0)
                                }
                            }
                        }
                    }.apply {
                        prefWidthProperty().bind(stage.widthProperty())
                    }
                }
                center {
                    webView {
                        engine.load("https://github.com/mslxl/KtGUI")
                    }
                }
            }
        }
        stage.title = "KtGUI - Mslxl's GitHub"
        stage.width = 1300.0
        stage.show()
    }

}

fun main(args: Array<String>) {
    Application.launch(KtGUIAbout::class.java, *args)
}