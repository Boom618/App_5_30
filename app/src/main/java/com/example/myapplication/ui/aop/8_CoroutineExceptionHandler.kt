package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 协程 CoroutineExceptionHandler
 */
fun main() = runBlocking() {

    val scope = CoroutineScope(EmptyCoroutineContext)

    val handler = CoroutineExceptionHandler { _, exception ->
        println("exception: $exception")
    }

    // 协程

    scope.launch(handler) {

        launch() {
            println(" child start")
            throw IllegalStateException("error")
        }
        println(" parent start")
    }


    delay(10000)

}
