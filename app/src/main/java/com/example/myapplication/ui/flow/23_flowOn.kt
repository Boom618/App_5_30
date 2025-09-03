package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flowOn  操作符：
 *
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow1 = flow {
        println("CoroutineContext flow :${currentCoroutineContext()}")
        // withContext 切换线程，包住 emit 会报错:java.lang.IllegalStateException: Flow invariant is violated:
//        withContext(Dispatchers.IO){
//            emit(1)
//        }
        for (i in 1..5) {
            emit(i)
        }

    }
        // 只管理上游的线程，不管理 collect 线程, 和 withContext 功能类似
        .flowOn(Dispatchers.IO)
        // map 是 两个 flowOn 之间的操作符，有下面的 newFixedThreadPoolContext 线程控制
        .map {
            // 后面的代码，不受 flowOn 的影响
            println("CoroutineContext map 2 :${currentCoroutineContext()}")
            it + 1
        }.flowOn(newFixedThreadPoolContext(2, "lastPool"))


    scope.launch {

        // fuse  融合
        flow1.map { it + 1 }
            .onEach {
                // 官方推荐 使用 onEach + flowOn 管理最后需要切换线程的代码
                println("collect: $it")
            }
            .flowOn(Dispatchers.IO)
            .collect {}

    }

    delay(10000)

}

