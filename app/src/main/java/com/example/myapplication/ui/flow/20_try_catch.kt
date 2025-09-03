package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * catch  操作符： 异常可见性
 *
 * try catch 适用所有场景
 * catch 操作符： 当 flow 中不能修改的无奈之举时，用 catch 操作符
 *
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    // 1】 flow 中有 操作符
    // 2】 map 操作符异常走向， 上游 大部分得操作符 异常都会被 emit 拦截

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow1 = flow {
        try {
            // 异常可见性： 在 flow 中 把 emit try catch ,会导致异常无法,传达到 collect 中
            emit(1)
            throw RuntimeException("flow 异常")
            emit(2)

        } catch (e: Exception) {
            // 为了让 collect 中能正常捕获异常，需要抛出
            throw e
        }
    }
        //.map { it * 2; throw Exception(" map Exception") }
        // catch 操作符 是捕捉上游异常得， 会过滤调 emit 抛出得异常
        .catch { println("catch: $it") }

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

