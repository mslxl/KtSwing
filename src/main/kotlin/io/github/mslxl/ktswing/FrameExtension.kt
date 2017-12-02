package io.github.mslxl.ktswing


import java.awt.*
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JRootPane
import javax.swing.WindowConstants.*

open class KtSwingFrame :JFrame("KtSwing"),Content{
    init {
        this.layout = CardLayout()
    }

    override fun onAddToContent(comp: JComponent){
        this.contentPane = comp
    }

}

inline fun frame(title:String="", frame: KtSwingFrame = KtSwingFrame(), init:KtSwingFrame.()->Unit):JFrame{
    frame.title = title
    init(frame)
    frame.isVisible = true
    return frame
}


inline fun KtSwingFrame.size(code:Dimension.()->Unit){
    this.size = this.size.apply(code)
}

inline fun KtSwingFrame.bounds(code: Rectangle.() -> Unit){
    this.bounds = this.bounds.apply(code)
}

inline fun KtSwingFrame.maxSize(code: Dimension.() -> Unit){
    this.maximumSize = this.maximumSize.apply(code)
}

inline fun KtSwingFrame.minSize(code: Dimension.() -> Unit){
    this.minimumSize = this.minimumSize.apply(code)
}

inline fun KtSwingFrame.maxBounds(code: Rectangle.() -> Unit){
    this.maximizedBounds = this.maximizedBounds.apply(code)
}


val KtSwingFrame.exitOnClose: Unit get() {
    defaultCloseOperation = EXIT_ON_CLOSE
}

val KtSwingFrame.disposeOnClose: Unit get() {
    defaultCloseOperation = DISPOSE_ON_CLOSE
}

val KtSwingFrame.doNothingOnClose: Unit get() {
    defaultCloseOperation = DO_NOTHING_ON_CLOSE
}

val KtSwingFrame.hideOnClose: Unit get() {
    defaultCloseOperation = HIDE_ON_CLOSE
}

val KtSwingFrame.resizable:Unit get() {
    isResizable = true
}

val KtSwingFrame.canNotResizable:Unit get() {
    isResizable = false
}