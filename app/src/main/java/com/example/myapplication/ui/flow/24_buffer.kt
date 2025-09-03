package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * buffer  操作符：
 *
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow1 = flow {
        for (i in 1..5) {
            emit(i)
            println("emit $i")
        }
    }
//        .buffer(1)
        // flowOn 自带缓冲功能，利用 ChannelFlow 来实现
//        .flowOn(Dispatchers.IO)
        // onBufferOverflow 缓冲策略
//        .buffer(2)
        // buffer 便携变种，只缓冲最新的一条数据的 buffer
//        .conflate()
        .map { it + 1 }



    scope.launch {
//        flow1.collectLatest {
        flow1
//            .conflate()
//            .mapLatest { it } // 先一次性 emit 1，2，3，4，5，再每隔一秒打印 2、3、4、5、6
            .collect {  // flow  是串行的 ，每隔一秒  【emit 1、collect 2】
                delay(1000)
                println("collect $it")
            }


    }

    delay(10000)

}

