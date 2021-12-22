package io.github.mslxl.ktswing

import java.awt.event.ActionEvent
import javax.swing.AbstractButton

fun <T : AbstractButton> BasicScope<out T>.onAction(listener: (event: ActionEvent) -> Unit) {
    self.addActionListener(listener)
}