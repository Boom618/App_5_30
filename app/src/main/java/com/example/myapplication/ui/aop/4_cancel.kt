package com.example.myapplication.ui.aop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.cancellation.CancellationException

/**
 * 协程 交互式 的取消
 */
fun main() = runBlocking() {

    val scope = CoroutineScope(EmptyCoroutineContext)

    var innerJob: Job? = null
    val job = launch(Dispatchers.Default) {

        var count = 0
        while (true) {
            /*if (isActive.not()) {
                println("isActive: $isActive")
                // 退出协程 常规做法不是 return@launch 而是抛出异常
                throw CancellationException()
                // return@launch
            }*/
            // ensureActive() 会检查isActive状态，如果不是active状态，会抛出异常,【等价】 上面那段代码
            ensureActive()
            count++
            if (count % 100_000_000 == 0){
                println(count)
            }
            if (count % 1_000_000_000 == 0){
                break
            }
        }
    }
    delay(1000)
    job.cancel()

}