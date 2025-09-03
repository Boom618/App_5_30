package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * 自定义 coroutineContext
 *
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking() {

    val scope = CoroutineScope(Dispatchers.IO + Job())
    val customContext = Logger()

    Job() + Dispatchers.IO + Job()
    // 同类型的 不能使用 + 号
   //  Job() + Job()
   //  Dispatchers.IO + Dispatchers.IO

    scope.launch(customContext) {
        coroutineContext[Logger]?.log("launch")
    }

    delay(10000)

}

/**
 * 自定义 CoroutineContext
 */
class Logger: AbstractCoroutineContextElement(Logger){
    companion object Key: CoroutineContext.Key<Logger>

    suspend fun log(msg: String) {
        println("${currentCoroutineContext()[Logger]} $msg")
    }
}
