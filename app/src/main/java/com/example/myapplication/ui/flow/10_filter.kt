package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow 操作符
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow1 = flowOf(1, 2, 3, 4, 5)
    val flow2 = flowOf(1, 2, null, 3, 4, null, 5)
    val flow3 = flowOf(1, 2, 3, "4", "5")

    scope.launch {
        // 保留返回 true 的数据
        flow1.filter { it % 2 == 0 }.collect { println("flow1-1 = $it") }
        flow2.filter { it?.rem(2) == 0 }.collect { println("flow2 1 = $it") }

        // 跟 filter 相反，保留 返回 false 的数据
        flow1.filterNot { it % 2 == 0 }.collect { println("flow1-2 = $it") }

        // 保留不为 null 的数据
        flow2.filterNotNull().filter { it % 2 == 0 }.collect { println("filterNotNull = $it") }

        // 保留符合的类型
        flow3.filterIsInstance<String>().collect{ println("filterIsInstance = $it") }
        flow3.filterIsInstance(String::class).collect{ println("filterIsInstance = $it") }
    }

    delay(10000)

}

