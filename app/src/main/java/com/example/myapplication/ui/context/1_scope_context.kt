package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor

fun main() = runBlocking() {

    // 协程上下文： 协程用到的所有信息
    // CoroutineContext

    // 协程作用域： CoroutineContext 的容器
    // 作用：1.启动协程 2.提供协程上下文
    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch{
        this.coroutineContext[Job]
        coroutineContext.job
        coroutineContext[ContinuationInterceptor]

        launch{
            println("coroutineContext: launchA")
        }
        launch{
            println("coroutineContext: launchB")
        }
        println("coroutineContext: launch scope")

    }

    delay(50000)




}