import io.github.mslxl.ktswing.config.ConfigHandler
import io.github.mslxl.ktswing.config.IConfig
import java.io.File

fun main(args: Array<String>) {
    val configInstance = ConfigHandler.newConfigInstance(Test::class.java, File("config.test")){
        name, oldValue, newValue ->
        println("$name: $oldValue --> $newValue")
    }
    println(configInstance.name.first)

    configInstance.name = 20 to "Test"
    println(configInstance.name.first)
    configInstance.name = 10 to "Te"
    print(configInstance.getN("a"))
}

interface Test:IConfig {
    var name:Pair<Int,String>
    fun getN(def:String):String
}