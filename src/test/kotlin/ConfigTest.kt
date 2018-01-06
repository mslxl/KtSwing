import io.github.mslxl.ktswing.config.ConfigHandler
import io.github.mslxl.ktswing.config.IConfig
import java.io.File

fun main(args: Array<String>) {
    val default = object :Test{
        override var booleanTest: Boolean
            get() = true
            set(value) = Unit
        override var defaultTest: Int
            get() = 3
            set(value) = Unit
        override var name: Pair<Int, String>
            get() = 1 to "3.14159"
            set(value) = Unit

        override fun getN(def: String): String = "空"

    }

    val configInstance = ConfigHandler.newConfigInstance(Test::class.java, File("config.test"),default){
        name, oldValue, newValue ->
        println("$name: $oldValue --> $newValue")
    }

    configInstance.booleanTest = false
    println()
    println()
    configInstance.keys.forEach {
        println("$it -> ${configInstance[it]}")
    }
}

interface Test:IConfig {
    var name:Pair<Int,String>
    fun getN(def:String):String
    var defaultTest:Int
    var booleanTest:Boolean
}