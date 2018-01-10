package io.github.mslxl.ktgui.common

import javax.swing.SwingUtilities
import javax.swing.SwingWorker
import kotlin.concurrent.thread

fun doAsync(isDaemon: Boolean = false, block: () -> Unit) = thread(isDaemon = isDaemon, block = block)

fun uiThread(block: () -> Unit) {
    SwingUtilities.invokeAndWait {block() }
}

fun uiThreadAsync(block: () -> Unit) {
    SwingUtilities.invokeLater {block() }
}

fun <T, V> doAsyncWorker(block: () -> T,
                         blockUIThreadProcess: (V) -> Unit = {},
                         blockDone: (T) -> Unit = {},
                         blockDoneCancelled: () -> Unit = {}) {
    object : SwingWorker<T, V>() {
        override fun doInBackground(): T = block()

        override fun process(chunks: MutableList<V>?) = chunks?.forEach(blockUIThreadProcess)!!

        override fun done() {
            if (isCancelled) blockDoneCancelled()
            else blockDone(get())
        }
    }.execute()
}

fun <T> doAsyncWorker(block: () -> Unit,
                              blockUIThreadProcess: (T) -> Unit = {}) {
    object : SwingWorker<Unit, T>() {
        override fun doInBackground() = block()

        override fun process(chunks: MutableList<T>?) = chunks?.forEach(blockUIThreadProcess)!!
    }.execute()
}