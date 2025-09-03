package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

/**
 * coroutineScope
 *
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking() {

    val scope = CoroutineScope(Dispatchers.IO)

    scope.launch() {
        // 2】 对串行模块的封装：coroutineScope 函数有返回值， 与 async 函数一样
        // coroutineScope 是一个挂起函数，它抛出的异常可以捕获，整个协程树不会受到影响
        val name =  try {
            coroutineScope {
                val deferred1 = async { "zhangsan" }
                val deferred2 : Deferred<String> = async { throw RuntimeException("Error") }
                "${deferred1.await()} ${deferred2.await()}"
            }
        } catch (e: Exception) {
            e.message
        }

        supervisorScope {

        }

        println("name = $name")
        // launch 没有返回值
        launch() {

        }
    }

    delay(10000)

}


// 1】 coroutineScope 第一个使用场景：在挂起函数中使用
private suspend fun someFun() = coroutineScope {
    // 提供了一个协程作用域，可以获取到当前协程的 context ，方便启动协程
    launch() {

    }
}

// 不用 coroutineScope 包一层，没发启动 launch 、async
private suspend fun showFun1() {
//    launch(){
//
//    }
}