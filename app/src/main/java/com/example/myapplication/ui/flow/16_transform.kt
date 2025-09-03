package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.transformLatest
import kotlinx.coroutines.flow.transformWhile
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * flow transform
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow2 = flow {
        delay(100)
        emit(1)
        delay(100)
        emit(2)
        delay(100)
        emit(3)
    }

    scope.launch {
        // 1】transform 更自由
        flow.transform {
            if (it > 0) {
                repeat(it) { _ ->
                    // it  为 transform 层的值
                    emit("$it - hhaha")
                }
            }
        }.collect { println("1: $it") }
        // map 底层 就是 transform
        // flow.map { it + 1 }.collect { println("2: $it") }

        // 2】 transform + takeWhile
        flow.transformWhile {
            // 大于 3 终止 flow
            if (it > 3) return@transformWhile false
            emit(it)

            // 返回值，当数据 大于 3 的时候，结束 flow
            // it <= 3
            true
        }.collect { println("2: $it ") }

        // 3】 transformLatest 有新数据，立即处理新的数据
        flow2.transformLatest {
            delay(50)
            emit("$it - start")
            delay(100)
            emit("$it - end")
        }.collect { println("3: $it ") }
    }

    delay(10000)

}

