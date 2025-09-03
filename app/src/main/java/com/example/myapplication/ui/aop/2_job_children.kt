package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 协程的父子关系
 */
fun main() = runBlocking() {

    val scope = CoroutineScope(EmptyCoroutineContext)

    var innerJob: Job? = null
    val job = scope.launch {

        innerJob = this.launch() {
            delay(100)
        }

    }

    val children = job.children
    println("children size : ${children.count()}")
    println("main end")
}