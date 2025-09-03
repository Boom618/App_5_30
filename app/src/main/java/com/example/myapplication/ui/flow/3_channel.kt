package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * channel  本质是一个挂起式队列
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    // Channel 函数，工厂函数
    val channel = Channel<String>()

    // 在一个协程中发送数据
    scope.launch{
        channel.send(channelData())
    }
    // 另一个协程中接收数据
    scope.launch{
        channel.receive()
    }


    delay(10000)

}

suspend fun channelData(): String{
    delay(100)
    return "channelData"
}
