package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * flow 时间窗口 操作符
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flow {
        delay(300)
        emit(1)
        delay(800)
        emit(2)
        delay(2000)
        emit(3)
    }


    scope.launch {
        // 超时： 从 collect 开始计时 ，超过就会抛出异常 TimeoutCancellationException
        // flow.timeout(1.seconds).collect { println("1： $it") }

        // sample 是固定时间间隔
        // 每次时间间隔内只保留最新的数据：应用场景，定时刷新，在刷新之前，只取最新的数据
        flow.sample(1.seconds).collect { println("2： $it") }

        // debounce ：防抖动、去抖动，超时后发送最后一次的数据。【点击抖动，不适用这个】
        flow.debounce(1.seconds).collect { println("3： $it") }

    }

    delay(10000)

}

/**
 * 点击 抖动
 */
fun <T> Flow<T>.throttle(timeWindow: Duration):Flow<T> = flow {
    var lastEmitTime = 0L
    collect{
        if (System.currentTimeMillis() - lastEmitTime > timeWindow.inWholeMilliseconds){
            emit(it)
            lastEmitTime = System.currentTimeMillis()
        }
    }
}
