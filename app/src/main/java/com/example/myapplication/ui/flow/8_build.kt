package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
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

    // 跨协程交互
    val flow6 = channelFlow {
        launch{
            delay(100)
            send(2)
        }
        delay(1000)
        send(1)
    }

    // flow 中 没有协程，不允许使用 launch，
    val flow7 = flow {
        // 这个 launch 会报错，是 最外层 runBlocking  的 context
        launch{
            delay(100)
            emit(2)
        }
        delay(1000)
        emit(1)
    }

    // 面向的是回调式 API 接口
//    val flow8 = callbackFlow {
//        getData()
//
//        // 拿到回调结果，关闭
//        awaitClose()
//    }

    scope.launch {
        flow1.collect {
            println("collect $it")
        }
    }




    delay(10000)

}


suspend fun getData(): Int {
    delay(1000)
    return 1
}

