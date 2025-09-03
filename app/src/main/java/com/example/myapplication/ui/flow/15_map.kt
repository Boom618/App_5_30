package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow map
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val flow2 = flow {
        delay(100)
        emit(1)
        delay(100)
        emit(2)
        delay(100)
        emit(3)
    }


    // flow 的数据都是线性的，同步的
    scope.launch {
        //
        flow.map { if (it == 3) null else it + 1 }.collect { println("1: $it") }

        // 过滤不为空的数据。mapNotNull 一个操作符，等价下面两个操作符
        flow.mapNotNull { if (it == 3) null else it + 1 }.collect { println("2: $it") }
        // 1】
        flow.map { if (it == 3) null else it + 1 }.filterNotNull()
        // 2】
        flow.filter { it != 3 }.map { it + 1 }
        // map 当前数据没有处理完，不会处理下一条数据， mapLatest 是异步计算
        // 只关注最新的数据，当有数据过来，上一个数据没有处理完，会丢弃。
        flow2.mapLatest { delay(120) ; it + 1}.collect{ println("3: $it") }
    }

    delay(10000)

}

