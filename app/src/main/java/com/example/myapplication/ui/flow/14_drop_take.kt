package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * flow drop 、take
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)


    scope.launch {
        // 丢弃前 2 个数据
        flow.drop(2).collect{ println("1: $it")}
        // 提供一个判断条件 ，凡是符合条件的丢弃，后面的都不检查，继续发送
        flow.dropWhile { it != 3 }.collect{ println("2: $it")}

        // 跟 drop 相反，保留前 2 条数据
        flow.take(2).collect{ println("3: $it")}
        // 给出一个判断，符合条件的时候保持发送，遇到不符合的，就停止发送
        flow.takeWhile { it < 3 }.collect{ println("4: $it")}
    }

    delay(10000)

}

