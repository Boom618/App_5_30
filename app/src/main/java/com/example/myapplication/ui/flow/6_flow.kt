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


    // sequence 提供 一个边生产边消费的队列
    val numbs = sequence {
        yield(1)
    }
    // 协程版 的 sequence
    val numbFlow = flow {
        emit(1)
    }.map { "map  $it" }


    scope.launch {
        // flow 遍历
        numbFlow.collect{
            println("numbFlow = $it")
        }

    }


    delay(10000)

}

