package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

/**
 * coroutineContext
 *
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

private fun flowFun() {
    flow<String> {
        // 1】获取 当前协程的 context
        coroutineContext
    }

    GlobalScope.launch(){
        flow<String> {
            //kotlin.coroutines.coroutineContext
            // 2】获取 当前协程的 context
            coroutineContext
            currentCoroutineContext()
        }
    }
}

private suspend fun showDispatcher() {
    delay(1000)
    println("showDispatcher ${coroutineContext[ContinuationInterceptor]}")
}