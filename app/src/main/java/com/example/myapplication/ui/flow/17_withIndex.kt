package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow withIndex
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
        // 编号 加  值
        flow.withIndex().collect { println("1: ${it.index} , ${it.value}") }

    }

    delay(10000)

}

