package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    // 协程版 的 sequence
    val numbFlow = flow {
        // 发送数据
        emit(1)
        delay(100)
        emit(2)
    }.map { "map  $it" }


    scope.launch {
        // flow 只有在 collect 才会生产数据
        numbFlow.collect{
            // collect 类似把 flow { }  中的代码 放到了 collect 中
            println("A : numbFlow = $it")
        }
    }

    scope.launch{
        delay(50)
        numbFlow.collect{
            // B 的 collect 和  A 的 collect 是两个协程互不干扰。数据都会完整打印
            println("B: numbFlow = $it")
        }
    }


    delay(10000)

}

