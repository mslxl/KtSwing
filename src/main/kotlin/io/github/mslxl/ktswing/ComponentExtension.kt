package io.github.mslxl.ktswing.component

import io.github.mslxl.ktswing.KtSwingDialog
import io.github.mslxl.ktswing.KtSwingFrame
import java.awt.Component
import java.awt.Container
import java.awt.Dimension
import java.awt.Rectangle
import javax.swing.JComponent

/**
 * Set bounds
 * 设置 Bounds
 */
inline fun JComponent.bounds(code: Rectangle.() -> Unit) {
    this.bounds = this.bounds.apply(code)
}

/**
 * Resize this JComponent
 * 缩放该 JComponent
 */
inline fun JComponent.size(code: Dimension.() -> Unit) {
    this.size = this.size.apply(code)
}

/**
 * Set maximumSize
 * 设置最大大小
 */
inline fun JComponent.maxSize(code: Dimension.() -> Unit) {
    this.maximumSize = this.maximumSize.apply(code)
}

/**
 * Set minimumSize
 * 设置最小大小
 */
inline fun JComponent.minSize(code: Dimension.() -> Unit) {
    this.minimumSize = this.minimumSize.apply(code)
}

/**
 * Get component's window from this component
 * 获取该 Component 的 Window
 */
val Component.window: Component
    get() {
        var comp = this
        while (comp.parent != null) {
            comp = comp.parent
        }
        return comp
    }

/**
 * Search a [T] by its name in own window
 *
 * 在 [Component] 所在的 Window 中 寻找 [T]
 * @param name Name
 * @param useCache Need try to find [T] in cache 是否在缓存中寻找 [T]
 */
fun <T> Component.findComponentByName(name: String, useCache: Boolean = true): T? {
    var root: Component? = this
    var last = this
    fun find(container: Container): Component? {
        val comps = container.components
        comps.forEach { it ->
            if (it.name != null && it != last) {
                if ((it.name == name) || (it.name.substring(it.name.indexOf(':') + 1) == name)) {
                    return it
                }
            } else if (it is Container) {
                val result = find(it)
                if (result != null) {
                    return result
                }
            }
        }
        return null
    }

    val window = this.window
    // 读取缓存
    var comp = with(window) {
        if (useCache)
            when (this) {
                is KtSwingFrame -> cache[name]
                is KtSwingDialog -> cache[name]
                else -> null
            }
        else null
    }
    // 没有缓存就去找
    if (comp == null) {
        do {
            if (root!!.name != null) {
                if ((root.name == name) or (root.name.substring(root.name.indexOf(':') + 1) == name)) {
                    comp = root
                    break
                }
            }
            if (root is Container) {
                comp = find(root)
                if (comp != null) {
                    break
                }
            }
            last = root
            root = root.parent
        } while (root != null)
    }
    return comp as T
}