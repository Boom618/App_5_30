package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext


fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)


    val deferred = scope.async {
        while (isActive) {
            contributors("http")
        }
    }

    // 1】 发送数据。后续的 flow  、SharedFlow 更适合处理
    val receiver = scope.produce<String> {
        while (isActive) {
            val data = contributors("http")
            send(data)
        }
    }

    // 2】接收数据
    launch {
        delay(2000)
        while (isActive) {
            println("deferred = ${receiver.receive()}")
        }
    }

    delay(10000)


}


suspend fun contributors(repo: String): String {
    delay(100)
    return "repo + $repo"
}