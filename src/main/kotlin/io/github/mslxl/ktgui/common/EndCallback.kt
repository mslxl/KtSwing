package io.github.mslxl.ktgui.common

/**
 * If a object is extend this interface, [EndCallback._endCallBack] will be invoked when it be added.
 *
 * 如果一个对象继承字该接口,那么在该对象添加完毕后将调用 [EndCallback._endCallBack] 函数
 */
@KtDSL
interface EndCallback{
    fun _endCallBack()
}