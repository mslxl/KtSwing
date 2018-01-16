package io.github.mslxl.ktgui.ktfx

import io.github.mslxl.ktgui.common.KtDSL
import io.github.mslxl.ktgui.common.PanelNode
import javafx.event.EventTarget
import javafx.scene.*
import javafx.scene.layout.Region
import javafx.scene.paint.Paint
import javafx.stage.Stage

@KtDSL
interface FxPanelNode: FxPanelNodePanel
@KtDSL
interface FxPanelNodePanel: PanelNode<Node>

inline fun <T : Node> FxPanelNodePanel._ktfx(comp: T, init: T.() -> Unit = {}): T {
    comp._ktfxInit()
    init.invoke(comp)
    this._onAddToContent(comp)
    return comp
}

fun <E : EventTarget> E._ktfxInit(): E {

    return this
}

inline fun _createFxPanelNode(crossinline block:(Node) -> Unit) = object :FxPanelNode{
    override fun _onAddToContent(comp: Node) {
        block.invoke(comp)
    }
}

inline fun _createFxPanelNodePanel(crossinline block:(Parent) -> Unit) = object :FxPanelNodePanel{
    override fun _onAddToContent(comp: Node) {
        block.invoke(comp as Parent)
    }
}

@KtDSL
inline fun Stage.createScene(block: _Scene.() -> Unit = {}): _Scene {
    var scene: _Scene? = null
    _createFxPanelNodePanel {
        scene = _Scene(this, it)
    }
    return (scene ?: _Scene(this, Group())).apply(block)
}

class _Scene : Scene, FxPanelNodePanel {
    override fun _onAddToContent(comp: Node) {
        if (comp is Parent) {
            root = comp
        }
    }

    val stage: Stage

    constructor(stage: Stage, root: Parent) : super(root) {
        this.stage = stage
    }

    constructor(stage: Stage, root: Parent, width: Double, height: Double) : super(root, width, height) {
        this.stage = stage
    }

    constructor(stage: Stage, root: Parent, fill: Paint?) : super(root, fill) {
        this.stage = stage
    }

    constructor(stage: Stage, root: Parent, width: Double, height: Double, fill: Paint?) : super(root, width, height, fill) {
        this.stage = stage
    }

    constructor(stage: Stage, root: Parent, width: Double, height: Double, depthBuffer: Boolean) : super(root, width, height, depthBuffer) {
        this.stage = stage
    }

    constructor(stage: Stage, root: Parent, width: Double, height: Double, depthBuffer: Boolean, antiAliasing: SceneAntialiasing?) : super(root, width, height, depthBuffer, antiAliasing) {
        this.stage = stage
    }
}

class FxUI(private val block: FxPanelNode.() -> Unit) {
    init {
        _createFxPanelNode {
            _node = it
            if (it is Parent) _parent = it
            if (it is Region) _region = it
        }.apply(block)
    }

    private lateinit var _node: Node
    private lateinit var _parent: Parent
    private lateinit var _region: Region

    val node get() = _node
    val parent get() = _parent
    val region get() = _region
}