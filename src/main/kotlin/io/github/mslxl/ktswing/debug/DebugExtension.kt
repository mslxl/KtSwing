package io.github.mslxl.ktswing.debug

import io.github.mslxl.ktswing.*
import java.awt.Frame
import java.awt.Window
import javax.swing.JFrame
import javax.swing.JSplitPane

fun Window.showDebugWindows(){
    Debug(this)
}

private class Debug(val debugWindow:Window):JFrame(){
    init {
        val title = if (debugWindow is Frame) debugWindow.title else "Window"
        frame("$title Debug",this){
            size {
                width = 600
                height = 400
            }
            cardpanel {
                splitPane {
                    left {
                        tree{

                        }
                    }
                    right {
                        
                    }
                }
            }
        }
    }
}