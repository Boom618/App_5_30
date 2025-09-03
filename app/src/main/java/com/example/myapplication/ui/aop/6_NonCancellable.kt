package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.measureTime

/**
 * 协程 不配合取消
 */
fun main() = runBlocking() {

    val scope = CoroutineScope(EmptyCoroutineContext)

    // 协程 cancel 会不会取消协程里面的任务


    val job = launch(Dispatchers.Default) {
        launch(NonCancellable){
            println("start")
            delay(3000)
            println("end")
        }
        writeInfo()
        // 2】不希望跟着协程一起取消 的场景 ： 日志记录
        launch(NonCancellable){
            // log
            println("log")
        }

        // 3】不希望跟着协程一起取消 的场景 ： 收尾工作
        withContext(Dispatchers.IO + NonCancellable){
            // 收尾工作
            delay(1000)
            println("clear ...")
         }
        println("parent start")
        delay(3000)
        println("parent end")

    }
    delay(1000)
    job.cancel()

    delay(10000)

}

// 1】不希望跟着协程一起取消 的场景 ： 1.写入文件 2.写入数据库
suspend fun writeInfo() = withContext(Dispatchers.IO + NonCancellable){
    //写到一半 被打断
    // 其中有挂起函数 , 如 读取数据库，写入文件
    delay(1000)
    println("write info")

}