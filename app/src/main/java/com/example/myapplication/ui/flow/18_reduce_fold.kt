package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.runningReduce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow reduce
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val list = listOf(1, 2, 3, 4, 5)

    //
    list.reduce { acc, i -> acc + i }.let { println("reduce sum =  $it") }

    // 跟 reduce 的区别是，fold 有一个初始值
    list.fold(10) { acc, i -> acc + i }.let { println("fold sum =  $it") }

    scope.launch {

        // flow 生产过程是挂起函数。reduce 启动了收集过程，
        // reduce 减少，等差数列求和。
        val sum = flow.reduce { acc, value -> acc + value }
        println("Flow sum = $sum")
        // runningReduce 会返回新的结果，每次收集都会输出一个值. list 、flow 分别都有 runningReduce
        list.runningReduce { acc, value -> acc + value }.let { println("runningReduce sum =  $it") }
        flow.runningReduce { acc, value -> acc + value }.collect { println("runningReduce sum =  $it") }

        // runningReduce 不是挂起函数，每次收集都会输出一个值，reduce 是挂起函数，只返回最后一次计算的值
        // reduce 只要最后一个结果，runningReduce 每次都会返回一个值
    }

    delay(10000)

}

