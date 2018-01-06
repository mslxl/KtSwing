package io.github.mslxl.ktswing.config

import com.google.gson.GsonBuilder
import java.io.File
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*
import kotlin.concurrent.thread

object ConfigHandler {
    private val gson = GsonBuilder().serializeNulls().create()
    fun <T : IConfig> newConfigInstance(iConfig: Class<T>, configFile: File,default:T, comments:String = "KtSwing config", onChange: (name: String, oldValue: Any?, newValue: Any) -> Unit): T {
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
                val key = method.name.substring(3).decapitalize()
                var valueIndex = 0
                try {
                    when {
                        method.name == "getKeys" -> return properties.keys.run {
                            val array = Array(size){"need init"}
                            this.forEachIndexed { index, any ->
                                array[index] = any.toString()
                            }
                            return@run array
                        }

                        method.name == "get" -> return getConfigValue(args!![0].toString(),Any::class.java){
                            valueIndex = 1
                            return@getConfigValue null
                        }
                        method.name == "set" -> {
                            valueIndex = 1
                            setConfigValue(args!![0].toString(),args[1])
                            return Unit
                        }

                        method.name.startsWith("get") -> return getConfigValue(key,method.returnType){
                            valueIndex = 0
                            return@getConfigValue if (args!=null && args.isNotEmpty()) args[0] else method.invoke(default)
                        }
                        method.name.startsWith("set") -> {
                            valueIndex = 0
                            onChange.invoke(key,gson.fromJson(properties[key].toString(), args!![0].javaClass), args[0])
                            setConfigValue(key,args[0])
                            return Unit
                        }
                        else -> return Unit
                    }
                }catch (e:Exception){
                    throw RuntimeException("KtSwing Error! Type is ${args!![valueIndex].javaClass.name}}",e)
                }
            }

            inline private fun <T:Any?> getConfigValue(key:String,ret:Class<T>,def:()->Any?):T?{
                if (!properties.containsKey(key)){
                    properties[key] = def.invoke()
                }
                return gson.fromJson(properties[key].toString(), ret)
            }

            private fun setConfigValue(key:String,value:Any?){
                properties[key] = gson.toJson(value)
            }

        }
        return Proxy.newProxyInstance(iConfig.classLoader, arrayOf(iConfig), proxy) as T
    }
    fun <T : IConfig> newConfigInstance(iConfig: Class<T>, configFile: File,default:T, comments:String = "KtSwing config"): T = newConfigInstance(iConfig, configFile,default, comments){ _,_,_-> }

}

