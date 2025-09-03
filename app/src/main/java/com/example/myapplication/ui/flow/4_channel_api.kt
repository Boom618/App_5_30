package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * channel  API
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    // Channel 函数，缓冲大小，丢弃策略
    val channel = Channel<String>(8, BufferOverflow.DROP_LATEST)

    // 在一个协程中发送数据
    scope.launch {
        channel.send(channelData())
        channel.close() // 发送端关闭， 再调用 send 会抛异常
    }
    // 另一个协程中接收数据
    scope.launch {
        channel.receive()
        channel.cancel() // 接收端关闭
    }


    delay(10000)

}

