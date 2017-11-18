package io.github.mslxl.ktswing.event

import java.awt.event.ActionEvent
import javax.swing.AbstractButton

fun AbstractButton.onActionPerformed(event: (ActionEvent) -> Unit) {
    addActionListener {
        event.invoke(it)
    }
}
