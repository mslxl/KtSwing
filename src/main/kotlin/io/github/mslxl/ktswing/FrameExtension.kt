package io.github.mslxl.ktswing


import java.awt.*
import java.awt.event.ComponentListener
import javax.swing.JComponent
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JRootPane
import javax.swing.WindowConstants.*


open class KtSwingFrame(title: String="KtSwing") :JFrame(title),Content{
    internal val cache = HashMap<String,Component>()
    init {
        this.layout = CardLayout()
    }

    override fun onAddToContent(comp: JComponent){
        this.contentPane = comp
    }
}

open class KtSwingDialog (title: String="",owner:JFrame,modal:Boolean=false):JDialog(owner,title,modal),Content{
    internal val cache = HashMap<String,Component>()
    init {
        this.layout = CardLayout()
    }

    override fun onAddToContent(comp: JComponent){
        this.contentPane = comp
    }
}

inline fun frame(title:String="", init:KtSwingFrame.()->Unit):JFrame{
    val frame = KtSwingFrame()
    frame.title = title
    init(frame)
    frame.isVisible = true
    return frame
}

inline fun dialog(title: String,owner: JFrame,modal: Boolean = false,init: KtSwingDialog.() -> Unit):JDialog{
    return KtSwingDialog(title,owner,modal).apply(init).apply {
        isVisible = true
    }
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