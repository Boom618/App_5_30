package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
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

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow1 = flow {
        try {
            for (i in 1..5) {
                emit(i)
            }
        } catch (e: Exception) {
            println(e)
        }

    }
        .onStart { println("onStart 1") }
        .onStart { println("onStart 2") }
        .onCompletion {
            // 可以拿到异常，但不拦截异常
            println("onCompletion $it")
        }.onEmpty {
            // 没有发送一条数据时，正常结束 触发；出现异常不触发
            println("onEmpty")
        }
        // catch 可以捕获整个 flow 上游的异常，try catch 不能捕获 onStart 中的异常
        .catch { println("catch: $it") }

    scope.launch {
        flow1.collect {
            // if (it == 2) throw NullPointerException("Null data")
            println("collect: $it")
        }

    }

    delay(10000)

}

