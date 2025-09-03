package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow1 = flowOf(1, 2, 3)
    val flow2 = listOf(1, 2, 3).asFlow()
    val flow3 = setOf(1, 2, 3).asFlow()

    val channel = Channel<Int>()
    val flow4 = channel.consumeAsFlow() // 只能被消费一次，否则抛异常
    val flow5 = channel.receiveAsFlow() // 事件被 collect 瓜分


    //  onEach + launchIn 等价下面的  scope.launch
    flow2.onEach {
        println(it)
    }.launchIn(scope)


    // 【flow 不允许切换协程调用 emit 】
    scope.launch {
        flow1.collect {

        }

    }

    scope.launch{
        // 组合 mapLatest  +  buffer
        flow3.collectLatest {  }
    }









    delay(10000)

}

