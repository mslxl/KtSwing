package io.github.mslxl.ktswing


import java.awt.Component
import java.awt.Container
import java.awt.FlowLayout
import javax.swing.JFrame
import javax.swing.JPanel

fun frame(title:String="",frame:JFrame = JFrame(),init:JFrame.()->Unit){
    frame.title = title
    init(frame)
    frame.isVisible = true
}

operator fun <F:Container> F.plus(comp: Component):F{
    this.add(comp)
    return this
}
