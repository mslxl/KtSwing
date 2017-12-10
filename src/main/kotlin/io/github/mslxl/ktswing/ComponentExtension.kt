package io.github.mslxl.ktswing

import java.awt.Component
import java.awt.Container
import java.awt.Dimension
import java.awt.Rectangle
import javax.swing.JComponent

inline fun JComponent.bounds(code: Rectangle.() -> Unit) {
    this.bounds = this.bounds.apply(code)
}


inline fun JComponent.size(code: Dimension.() -> Unit) {
    this.size = this.size.apply(code)
}

inline fun JComponent.maxSize(code: Dimension.() -> Unit) {
    this.maximumSize = this.maximumSize.apply(code)
}

inline fun JComponent.minSize(code: Dimension.() -> Unit) {
    this.minimumSize = this.minimumSize.apply(code)
}

val Component.window:Component
    get() {
        var comp = this
        while (comp.parent != null) {
            comp = comp.parent
        }
        return comp
    }

fun <T> Component.findComponentByName(name: String, useCache: Boolean = true, saveCache: Boolean = true): T? {

    var root: Component? = this
    var last = this

    fun find(container: Container): Component? {
        val comps = container.components
        comps.filter { it -> (it != last) and (it.name != null) }
                .forEach { it ->
                    if ((it.name == name) or (it.name.substring(it.name.indexOf(':') + 1) == name)) {
                        return it
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

        // 保存缓存
        if ((comp != null) and saveCache) {
            with(window) {
                when (this) {
                    is KtSwingFrame -> cache[comp!!.name] = comp!!
                    is KtSwingDialog -> cache[comp!!.name] = comp!!
                }
            }
        }

    }

    return comp as T

}