package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor

fun main() = runBlocking(){

    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch(Dispatchers.Default){
        val outer = scope.coroutineContext[ContinuationInterceptor]
        val inner = coroutineContext[ContinuationInterceptor]

        println("outer: $outer")
        println("inner: $inner")

        coroutineContext[Job]
    }

    println("main end")
}