package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * retry  操作符： 重启 flow
 *
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    // 1】 flow 中有 操作符
    // 2】 map 操作符异常走向， 上游 大部分得操作符 异常都会被 emit 拦截

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow1 = flow {
        emit(1)
    }.retry(3) { // 重试次数

        // 返回 true 表示 重试， false 表示 不重试
        true
    }.retryWhen { exception, attempt ->
        // exception ： 异常   attempt 重试过的次数
        true
    }

    scope.launch {
        try {
            flow1.collect {
                if (it == 2) throw NullPointerException("Null data")
                println("collect: $it")
            }
        } catch (e: Exception) {

        }

    }

    delay(10000)

}

