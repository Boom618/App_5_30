package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * channel  API
 */
@OptIn(ObsoleteCoroutinesApi::class)
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    // Channel 函数，缓冲大小，丢弃策略
    val channel = Channel<String>(8, BufferOverflow.DROP_LATEST)

    // actor 函数, 把 channel 创建和发送 的逻辑封装到 actor 中，返回一个 actor 对象
    val sender = scope.actor<Int> {
        for (num in this) {
            println("sender send $num")
        }
    }

    scope.launch {
        for (num in 1..100) {
            sender.send(num)
            delay(1000)
        }
    }


    delay(10000)

}

