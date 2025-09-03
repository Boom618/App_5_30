package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * onEach
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val list = listOf(1, 2, 3, 4, 5)


    scope.launch {
        // onEach 不修改原 flow
        flow.onEach {
            println("onEach 1: $it")
        }.onEach {
            println("onEach 2: $it")
        }.filter {
            it % 2 == 0
        }.onEach {
            println("onEach 3: $it")
        }.collect {
            println("collect: $it")
        }

    }

    delay(10000)

}

