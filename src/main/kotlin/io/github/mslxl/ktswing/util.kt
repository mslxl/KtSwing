@file:Suppress("unused")

package io.github.mslxl.ktswing

import java.awt.Container
import java.awt.Rectangle

@DslMarker
annotation class KtSwingMarker()

fun Rectangle.withX(x: Int) = Rectangle(x, this.y, this.width, this.height)
fun Rectangle.withY(y: Int) = Rectangle(this.x, y, this.width, this.height)
fun Rectangle.withW(w: Int) = Rectangle(this.x, this.y, w, this.height)
fun Rectangle.withH(h: Int) = Rectangle(this.x, this.y, this.width, h)
