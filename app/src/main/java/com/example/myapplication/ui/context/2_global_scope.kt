package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.EmptyCoroutineContext

/**
 * GlobalScope
 * 单例对象，没有内置得 job
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking() {

    val scope = CoroutineScope(Dispatchers.IO)
    // GlobalScope.launch 等价 CoroutineScope(EmptyCoroutineContext)
    CoroutineScope(EmptyCoroutineContext).launch(){

    }

    scope.launch(){

    }
    val job = GlobalScope.launch(){
        this.coroutineContext[Job]
        coroutineContext.job
        coroutineContext[ContinuationInterceptor]

    }
    println("job.parent = ${job.parent}")
    delay(10000)

}