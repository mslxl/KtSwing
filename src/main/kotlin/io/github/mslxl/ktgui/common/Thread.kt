@file:JvmName("KtGUI")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.common

import javafx.application.Platform
import javax.swing.SwingUtilities
import kotlin.concurrent.thread

inline fun awtThread(crossinline block: () -> Unit) {
    SwingUtilities.invokeLater { block.invoke() }
}

inline fun awtThedaFinally(crossinline block: () -> Unit) {
    SwingUtilities.invokeAndWait { block.invoke() }
}

inline fun fxThread(noinline block: () -> Unit) {
    Platform.runLater(block)
}

inline fun newThead(noinline block: () -> Unit) {
    thread(start = true, block = block)
}