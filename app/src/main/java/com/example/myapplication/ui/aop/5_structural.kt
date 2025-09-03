package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.measureTime

/**
 * 协程 结构化 的取消
 */
fun main() = runBlocking() {

    val scope = CoroutineScope(EmptyCoroutineContext)

    // 协程 cancel 会不会取消协程里面的任务

    val job = launch(Dispatchers.Default) {
        launch(){

            println("start")
            delay(3000)
            println("end")
        }

    }
    delay(1000)
    job.cancel()
    // 计算协程的执行时间
    measureTime { job.join() }.also { println("Duration = $it") }
    job.cancelAndJoin()
    delay(10000)

}