package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow 自定义 操作符
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow1 = flowOf(1, 2, 3, 1)
    val flow2 = flowOf("java", "Java", "JAVA.com")


    scope.launch {
        // collect 实际代码
        flow1.customOperator().collect(object : FlowCollector<Int>{
            override suspend fun emit(value: Int) {
                println("1: $value")
            }
        })

        flow1.double().collect{
            println("2: $it")
        }
    }

    delay(10000)

}


/**
 * 自定义操作符: flow 的扩展函数
 * 泛型函数；fun <T>
 * 返回值类型：Flow<T>
 */
fun <T> Flow<T>.customOperator(): Flow<T> = flow {
    // 基于 flow 或 channelFlow
    // 类似 collect{ emit(it) }
    this@customOperator.collect {
        // channelFlow 用 send(it)
        emit(it)
        emit(it)
    }
}


/**
 * 自定义操作符: 确定的类型
 */
fun Flow<Int>.double(): Flow<Int> = channelFlow {
    collect {
        send(it * 2)
    }
}