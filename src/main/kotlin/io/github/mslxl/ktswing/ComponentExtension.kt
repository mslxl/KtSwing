package io.github.mslxl.ktswing

import java.awt.*
import javax.swing.JComponent
import javax.swing.JFrame

inline fun JComponent.bounds(code:Rectangle.()->Unit){
    this.bounds = this.bounds.apply(code)
}


inline fun JComponent.size(code:Dimension.()->Unit){
    this.size = this.size.apply(code)
}

inline fun JComponent.maxSize(code: Dimension.() -> Unit){
    this.maximumSize = this.maximumSize.apply(code)
}

inline fun JComponent.minSize(code: Dimension.() -> Unit){
    this.minimumSize = this.minimumSize.apply(code)
}

fun <T> Component.findComponentByName(name:String):T?{
    var root = this
    while (root.parent!=null){
        root = root.parent
    }
    fun find(container: Container):Component?{
        container.components.forEach {
            if (it.name == name){
                return it
            } else if (it is Container){
                return find(it)
            }
        }
        return null
    }

    return find(root as Container) as T
}