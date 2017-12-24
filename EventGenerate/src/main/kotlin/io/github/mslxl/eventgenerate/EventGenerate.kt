package io.github.mslxl.eventgenerate

import java.awt.Component
import java.awt.Container
import java.awt.Window
import java.awt.event.*
import java.beans.PropertyChangeListener
import java.io.File
import java.lang.reflect.Method
import java.text.DateFormat
import java.util.*
import javax.swing.*
import javax.swing.event.*

// 此文件用于自动生成 Listener DSL

// 这代码我自己都看着恶心...
// 一定要用 IDE 的折叠净眼
// 不要使用代码格式化!!!

// 直接输出到 src 目录
val TOSRC = true

fun HashMap<Class<out Component>, Array<Pair<String,Class<*>>>>.saveListToMap(){
    val s = this

    // FocusListener
    codeBlock {
        s[Component::class.java] = arrayOf("addFocusListener" to FocusListener::class.java as Class<*>)
    }

    // Window
    codeBlock {
        s[Window::class.java] = arrayOf(
                "addWindowFocusListener" to WindowFocusListener::class.java as Class<*>,
                "addWindowListener" to WindowListener::class.java as Class<*>)
    }

    // Component
    codeBlock {
        s[Component::class.java] = arrayOf(
                "addMouseListener" to MouseListener::class.java as Class<*>,
                "addMouseWheelListener" to MouseWheelListener::class.java as Class<*>,
                "addMouseMotionListener" to MouseMotionListener::class.java as Class<*>,
                "addKeyListener" to KeyListener::class.java as Class<*>,
                "addFocusListener" to FocusListener::class.java as Class<*>)
    }

    // AbstractButton
    codeBlock {
        s[AbstractButton::class.java] = arrayOf(
                "addActionListener" to ActionListener::class.java as Class<*>,
                "addChangeListener" to ChangeListener::class.java as Class<*>
        )
    }

    // JList
    codeBlock {
        s[JList::class.java] = arrayOf("addListSelectionListener" to ListSelectionListener::class.java as Class<*>)
    }

    // JTree
    codeBlock {
        s[JTree::class.java] = arrayOf(
                "addTreeExpansionListener" to TreeExpansionListener::class.java as Class<*>,
                "addTreeWillExpandListener" to TreeWillExpandListener::class.java as Class<*>,
                "addTreeSelectionListener" to TreeSelectionListener::class.java as Class<*>)
    }

    // Container
    codeBlock {
        s[Container::class.java] = arrayOf(
                "addPropertyChangeListener" to PropertyChangeListener::class.java as Class<*>
        )
    }

    // JComboBox
    codeBlock {
        s[JComboBox::class.java] = arrayOf(
                "addItemListener" to ItemListener::class.java as Class<*>,
                "addPopupMenuListener" to PopupMenuListener::class.java as Class<*>
        )
    }

    // JTabbedPane
    codeBlock {
        s[JTabbedPane::class.java] = arrayOf(
                "addChangeListener" to ChangeListener::class.java as Class<*>
        )
    }

}

inline fun codeBlock(code:()->Unit) = code.invoke()

fun main(args: Array<String>) {
    val map = HashMap<Class<out Component>, Array<Pair<String,Class<*>>>>()

    map.saveListToMap()

    val src:File
    var packageName = ""

    if (TOSRC){
        src = File("src/main/kotlin/io/github/mslxl/ktswing/event")
        packageName = "io.github.mslxl.ktswing.event"
        //error("我不放心 I do not believe it")
    }else{
        src = File("codeGenerate").apply {

            if (!exists()) mkdirs()
        }
    }
    println("Output to \"${src.absolutePath}\"")
    map.forEach {
        entry->
        entry.value.forEach {
            if (!File(src,"_${it.second.simpleName}.kt").exists()){
                val method = entry.key.getDeclaredMethod(it.first,it.second)
                val eventClass = generateFile(it.second, entry.key, method, packageName)
                println(eventClass)
                File(src,"${entry.key.simpleName}_${it.second.simpleName}.kt").apply { if (!exists()) createNewFile() }.writeText(eventClass)
            }

        }
    }
}
private fun generateFile(clazz: Class<*>, who:Class<*>, addMethod:Method,packageName:String):String{
    return if (clazz.declaredMethods.size > 1) generateCode(clazz, who, addMethod, packageName) else generateCodeOne(clazz, who, addMethod, packageName)
}

private fun generateCodeOne(clazz: Class<*>, who:Class<*>, addMethod:Method,packageName:String=""):String{
    val method = clazz.declaredMethods

    return """
        ${
            if (packageName!="") "package $packageName" else ""
        }

        // Generate by KtSwing in ( ${DateFormat.getDateTimeInstance().format(Date())} )

        fun ${who.name}${if (who.hasTypeParameters()) "<*>" else ""}.${clazz.simpleName.firstCharLowerCase()}(init:(${generateArgsTypeList(method[0])})->Unit){
            ${addMethod.name}(object:${clazz.name}${if (clazz.isInterface) "" else "()"}{
                ${
                    buildString {
                        method[0].let {
                            appendln()
                            appendln("                override fun ${it.name}(${generateArgsList(it)}){")
                            appendln("                        init.invoke(${generateArgsNameList(it)})")
                            appendln("                }")
                            appendln()
                    }
                }
    }
            })
        }
    """.trimIndent()
}

private fun generateCode(clazz: Class<*>, who:Class<*>, addMethod:Method,packageName:String=""):String{
    val method = clazz.declaredMethods
    return """
        ${
            if (packageName!="") "package $packageName" else ""
        }
        // Generate by KtSwing in ( ${DateFormat.getDateTimeInstance().format(Date())} )

        class _${clazz.simpleName}(val component:${who.name}){

            // Code block 1
            ${
                buildString {
                    method.forEach {
                        appendln()
                        appendln("            private var ${it.name}Field:((${generateArgsTypeList(it)})->Unit)? = null")
                    }
                }
            }

            // Code block 2
            private val listener = object : ${clazz.name}${if (!clazz.isInterface) "()" else "" }{
                ${
                    buildString {
                        method.forEach {
                            appendln()
                            appendln("                override fun ${it.name}(${generateArgsList(it)}){")
                            appendln("                    ${it.name}Field?.invoke(${generateArgsNameList(it)})")
                            appendln("                }")
                        }
                    }
                }
            }

            // Code block 3
            init{
                component.${addMethod.name}(listener)
            }

            // Code block 4
            ${
                buildString {
                    method.forEach {
                        appendln()
                        appendln("            fun ${generateMethodName(it)}(event:(${generateArgsTypeList(it)})->Unit){")
                        appendln("                ${it.name}Field = event")
                        appendln("            }")
                        appendln()
                    }

                }
            }
        }

        inline fun ${who.name}.${clazz.simpleName.firstCharLowerCase()}(init: _${clazz.simpleName}.()->Unit) = _${clazz.simpleName}(this).apply(init)

    """.trimIndent()
}
private fun Class<*>.hasTypeParameters() = typeParameters.isNotEmpty()
private fun generateArgsList(method: Method):String{
    return buildString {
        val args = method.parameters
        args.forEachIndexed{
            index,arg->
            append("arg$index:${arg.type.name}")
            if (index!=args.size-1){
                append(",")
            }
        }
    }
}

private fun generateArgsTypeList(method: Method):String{
    return buildString {
        val args = method.parameters
        args.forEachIndexed{
            index,arg->
            append(arg.type.name)
            if (index!=args.size-1){
                append(",")
            }
        }
    }
}

private fun generateArgsNameList(method: Method):String{
    return buildString {
        val args = method.parameters
        args.forEachIndexed{
            index,arg->
            append("arg$index")
            if (index!=args.size-1){
                append(",")
            }
        }
    }
}

private fun generateMethodName(method: Method):String{
    val methodString = method.name.toCharArray()
    methodString[0] = methodString[0].toUpperCase()
    return "on${String(methodString)}"
}

fun String.firstCharLowerCase():String{
    val chars = this.toCharArray()
    chars[0] = chars[0].toLowerCase()
    return String(chars)
}