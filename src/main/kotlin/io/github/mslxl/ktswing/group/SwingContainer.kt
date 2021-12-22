package io.github.mslxl.ktswing.group

import io.github.mslxl.ktswing.ContainerScope
import java.awt.Container


fun <T : Container> swing(block: ContainerScope<T>.() -> Unit): SwingContainer<T> {
    return SwingContainer(block)
}

fun <T : Container> ContainerScope<T>.use(group: SwingContainer<T>) {
    group.initWith(this)
}

operator fun <T : Container> ContainerScope<T>.plusAssign(group: SwingContainer<T>) {
    use(group)
}

@JvmInline
value class SwingContainer<T : Container>(private val block: ContainerScope<T>.() -> Unit) {
    val initBlock get() = block
    private fun applyWithContainerScope(scope: ContainerScope<T>) {
        scope.apply(block)
    }

    private fun applyWithPanel(panel: T) {
        applyWithContainerScope(ContainerScope(panel))
    }

    fun initWith(panel: T) {
        applyWithPanel(panel)
    }

    fun initWith(panel: ContainerScope<T>) {
        applyWithContainerScope(panel)
    }

    operator fun invoke(panel: T) = initWith(panel)
    operator fun invoke(panel: ContainerScope<T>) = initWith(panel)
}