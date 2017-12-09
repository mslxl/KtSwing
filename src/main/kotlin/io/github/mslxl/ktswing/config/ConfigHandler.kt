package io.github.mslxl.ktswing.config

import com.google.gson.GsonBuilder
import java.io.File
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.text.DateFormat
import java.util.*
import kotlin.concurrent.thread

object ConfigHandler {
    private val gson = GsonBuilder().serializeNulls().create()
    fun <T : IConfig> newConfigInstance(iConfig: Class<T>, configFile: File, comments:String = "KtSwing config", onChange: (name: String, oldValue: Any?, newValue: Any) -> Unit): T {
        val proxy = object : InvocationHandler {
            val file: File = configFile
            val properties = Properties()
            init {
                if (configFile.exists()){
                    val reader = file.reader()
                    properties.load(reader)
                    reader.close()
                }
                Runtime.getRuntime().addShutdownHook(thread(start = false){
                    val writer = file.writer()
                    properties.store(writer,comments)
                    writer.close()
                })
            }

            override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
                val name = method.name.substring(3).toCharArray().run {
                    this[0] = this[0].toLowerCase()
                    String(this)
                }
                if (method.name.startsWith("get")) {
                    if (!properties.containsKey(name)){
                        properties[name] = gson.toJson(null)
                    }
                    return gson.fromJson(properties[name].toString(), method.returnType)
                } else if (method.name.startsWith("set")) {
                    onChange.invoke(name,gson.fromJson(properties[name].toString(), args!![0].javaClass),args!![0])
                    properties[name] = gson.toJson(args[0])
                }
                return Unit
            }
        }
        return Proxy.newProxyInstance(iConfig.classLoader, arrayOf(iConfig), proxy) as T
    }
    fun <T : IConfig> newConfigInstance(iConfig: Class<T>, configFile: File, comments:String = "KtSwing config"): T = newConfigInstance(iConfig, configFile, comments){ _,_,_-> }
}

