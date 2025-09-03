package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.measureTime

/**
 * 协程 结构化异常管理
 */
fun main() = runBlocking() {

    val scope = CoroutineScope(EmptyCoroutineContext)

    // 协程

    scope.launch() {

        launch() {
            println(" child start")
            // 协程的异常流程 ：只有一种 1.抛出异常，
            //  1、会取消所关联的 父、子 协程 2、异常流程不能用 cancel 方法取消 3、协程的异常最终会到达线程世界
            throw IllegalStateException("error")
        }
        println(" parent start")
    }
    // 协程的取消流程：方式有两种 1.抛出异常 2.调用 cancel 方法。
    // 【注意】取消的是当前协程，及 子协程，不会取消父协程
    throw CancellationException()
    scope.cancel()

    delay(10000)

}
