package io.github.mslxl.ktswing


import java.awt.Component
import java.awt.Container
import java.awt.Dimension
import java.awt.Rectangle
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.WindowConstants.*

inline fun frame(title:String="", frame: JFrame = JFrame(), init:JFrame.()->Unit):JFrame{
    frame.title = title
    init(frame)
    frame.isVisible = true
    return frame
}


inline fun JFrame.size(code:Dimension.()->Unit){
    this.size = this.size.apply(code)
}

inline fun JFrame.bounds(code: Rectangle.() -> Unit){
    this.bounds = this.bounds.apply(code)
}

inline fun JFrame.maxSize(code: Dimension.() -> Unit){
    this.maximumSize = this.maximumSize.apply(code)
}

inline fun JFrame.minSize(code: Dimension.() -> Unit){
    this.minimumSize = this.minimumSize.apply(code)
}

inline fun JFrame.maxBounds(code: Rectangle.() -> Unit){
    this.maximizedBounds = this.maximizedBounds.apply(code)
}


val JFrame.exitOnClose: Unit get() {
    defaultCloseOperation = EXIT_ON_CLOSE
}

val JFrame.disposeOnClose: Unit get() {
    defaultCloseOperation = DISPOSE_ON_CLOSE
}

val JFrame.doNothingOnClose: Unit get() {
    defaultCloseOperation = DO_NOTHING_ON_CLOSE
}

val JFrame.hideOnClose: Unit get() {
    defaultCloseOperation = HIDE_ON_CLOSE
}

val JFrame.resizable:Unit get() {
    isResizable = true
}

val JFrame.canNotResizable:Unit get() {
    isResizable = false
}