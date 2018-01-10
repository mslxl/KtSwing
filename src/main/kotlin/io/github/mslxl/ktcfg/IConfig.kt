package io.github.mslxl.ktcfg

interface IConfig {
    val keys:Array<String>
        get() = arrayOf()

    operator fun get(key:String):Any? = null
    operator fun set(key: String,value:Any):Any? = null
}