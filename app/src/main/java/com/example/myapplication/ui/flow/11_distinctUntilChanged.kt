package com.example.myapplication.ui.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * flow 操作符
 */
fun main() = runBlocking() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow1 = flowOf(1, 2, 2, 3, 3, 1)
    val flow2 = flowOf("java","Java","JAVA.com")


    scope.launch {
        // 过滤连续的重复数据，结果： 1，2，3，1 【保留的是相同元素的第一个】
        flow1.distinctUntilChanged().collect{ println( "1: $it")}
        // 忽略大小写
        flow2.distinctUntilChanged{a,b -> a.uppercase() == b.uppercase()}.collect{ println( "2: $it")}

        // distinctUntilChangedBy 先把所有元素转成大写，再比较，不改变原数据
        flow2.distinctUntilChangedBy { it.uppercase() }.collect{ println( "3: $it")}


    }

    delay(10000)

}

