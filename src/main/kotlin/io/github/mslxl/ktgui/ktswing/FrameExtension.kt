package io.github.mslxl.ktgui.ktswing


import io.github.mslxl.ktgui.common.KtDSL
import java.awt.*
import javax.swing.JComponent
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.WindowConstants.*

interface NodeNameCache {
    val cache: HashMap<String, Component>
}

/**
 * [JFrame] in KtSwing is this
 * You need to call [KtSwingFrame.isVisible] to show it
 * [JFrame] 在 KtSwing 中是 [KtSwingFrame]
 * 你需要调用 [KtSwingFrame.isVisible] 来显示它
 */
@KtDSL
open class KtSwingFrame(title: String = "KtSwing") : JFrame(title), SwingPanelNode, NodeNameCache {
    override val cache: HashMap<String, Component> = HashMap()

    init {
        this.layout = CardLayout()
    }

    override fun _onAddToContent(comp: JComponent) {
        this.contentPane = comp
    }
}

/**
 * [JDialog] in KtSwing is [KtSwingDialog]
 * You need to call [KtSwingDialog.isVisible] to show it
 *
 * [JDialog] 在 KtSwing 中是 [KtSwingDialog]
 * 你需要调用 [KtSwingDialog.isVisible] 来显示它
 */
@KtDSL
open class KtSwingDialog(title: String = "", owner: JFrame, modal: Boolean = false) : JDialog(owner, title, modal), SwingPanelNode, NodeNameCache {
    override val cache = HashMap<String, Component>()

    init {
        this.layout = CardLayout()
    }

    override fun _onAddToContent(comp: JComponent) {
        this.contentPane = comp
    }
}

/**
 * Create a [JFrame] and show it
 * 创建一个 [JFrame] 并显示
 */
@KtDSL
inline fun frame(title: String = "", init: KtSwingFrame.() -> Unit): JFrame {
    val frame = KtSwingFrame()
    frame.title = title
    init(frame)
    frame.isVisible = true
    return frame
}

/**
 * Create a [JDialog] and show it
 * 创建一个 [JDialog] 并显示
 */
@KtDSL
inline fun dialog(title: String, owner: JFrame, modal: Boolean = false, init: KtSwingDialog.() -> Unit): JDialog {
    return KtSwingDialog(title, owner, modal).apply(init).apply {
        isVisible = true
    }
}

/**
 * Resize this window
 * 缩放窗口
 */
inline fun Window.size(code: Dimension.() -> Unit) {
    this.size = this.size.apply(code)
}

/**
 * Set bounds
 * 设置 Bounds
 */
inline fun Window.bounds(code: Rectangle.() -> Unit) {
    this.bounds = this.bounds.apply(code)
}

/**
 * Set maximumSize
 * 设置最大大小
 */
inline fun Window.maxSize(code: Dimension.() -> Unit) {
    this.maximumSize = this.maximumSize.apply(code)
}

/**
 * Set minimumSize
 * 设置最小大小
 */
inline fun Window.minSize(code: Dimension.() -> Unit) {
    this.minimumSize = this.minimumSize.apply(code)
}

/**
 * Set maximizedBounds
 * 设置最大 Bounds
 */
inline fun Frame.maxBounds(code: Rectangle.() -> Unit) {
    this.maximizedBounds = this.maximizedBounds.apply(code)
}

/**
 * Let Java exit when this window close
 * 当窗口关闭时退出 Java
 */
val KtSwingFrame.exitOnClose: Unit
    get() {
        defaultCloseOperation = EXIT_ON_CLOSE
    }

/**
 * Let this window dispose when it close
 * 仅关闭窗口
 */
val KtSwingFrame.disposeOnClose: Unit
    get() {
        defaultCloseOperation = DISPOSE_ON_CLOSE
    }
/**
 * Do noting when this window close
 * 当窗口关闭时啥事也不做
 */
val KtSwingFrame.doNothingOnClose: Unit
    get() {
        defaultCloseOperation = DO_NOTHING_ON_CLOSE
    }

/**
 * Hide this window when it close
 * 当窗口关闭时隐藏它
 */
val KtSwingFrame.hideOnClose: Unit
    get() {
        defaultCloseOperation = HIDE_ON_CLOSE
    }

/**
 * Allow this window to resize
 * 使窗口可调大小
 */
val KtSwingFrame.resizable: Unit
    get() {
        isResizable = true
    }

/**
 * Not allow this window resize
 * 使窗口不可调大小
 */
val KtSwingFrame.canNotResizable: Unit
    get() {
        isResizable = false
    }

/**
 * Set visible to true
 * 设置窗口为可见
 */
fun Window.showWindow(): Unit {
    isVisible = true
}