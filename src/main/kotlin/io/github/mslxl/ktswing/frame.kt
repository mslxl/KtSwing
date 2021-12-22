@file:Suppress("unused")
package io.github.mslxl.ktswing

import java.awt.Frame
import javax.swing.JFrame
import javax.swing.WindowConstants.*


inline fun <T : JFrame> customFrame(frame: T, block: FrameScope<T>.() -> Unit): T {
    return FrameScope(frame).apply(block).self
}

inline fun frame(visible: Boolean = true, block: FrameScope<JFrame>.() -> Unit) = customFrame(JFrame(), block).apply {
    isVisible = visible
}

/**
 * Let Java exit when this window close
 * 当窗口关闭时退出 Java
 */
val FrameScope<out JFrame>.exitOnClose: Unit
    get() = self.exitOnClose

/**
 * Let this window dispose when it close
 * 仅关闭窗口
 */
val FrameScope<out JFrame>.disposeOnClose: Unit
    get() = self.disposeOnClose

/**
 * Do nothing when this window close
 * 当窗口关闭时啥事也不做
 */
val FrameScope<out JFrame>.doNothingOnClose: Unit
    get() = self.doNothingOnClose

/**
 * Hide this window when it close
 * 当窗口关闭时隐藏它
 */
val FrameScope<out JFrame>.hideOnClose: Unit
    get() = self.hideOnClose

/**
 * Allow this window to resize
 * 使窗口可调大小
 */
val FrameScope<out Frame>.resizable: Unit
    get() {
        self.isResizable = true
    }


/**
 * Not allow this window resize
 * 使窗口不可调大小
 */
val JFrame.canNotResizable: Unit
    get() {
        isResizable = false
    }


/**
 * Let Java exit when this window close
 * 当窗口关闭时退出 Java
 */
val JFrame.exitOnClose: Unit
    get() {
        defaultCloseOperation = EXIT_ON_CLOSE
    }

/**
 * Let this window dispose when it close
 * 仅关闭窗口
 */
val JFrame.disposeOnClose: Unit
    get() {
        defaultCloseOperation = DISPOSE_ON_CLOSE
    }

/**
 * Do nothing when this window close
 * 当窗口关闭时啥事也不做
 */
val JFrame.doNothingOnClose: Unit
    get() {
        defaultCloseOperation = DO_NOTHING_ON_CLOSE
    }

/**
 * Hide this window when it close
 * 当窗口关闭时隐藏它
 */
val JFrame.hideOnClose: Unit
    get() {
        defaultCloseOperation = HIDE_ON_CLOSE
    }

