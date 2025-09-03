package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
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

        val async = async() {
            println(" child start")
            throw IllegalStateException("error")
        }
        launch(){
            async.await()
        }
        println(" parent start")

        // SupervisorJob()
    }


    delay(10000)

}
