package com.example.myapplication.ui.flow

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main() = runBlocking() {
    /**
     * StateFlow SharedFlow 是 订阅模式、 Flow 不是订阅模式，是 流
     */
    // StateFlow 状态流  ，基于 SharedFlow 实现
    // SharedFlow 事件流 ，基于 Flow 实现

    // Flow   : data  flow  数据流

    // Channel ： 多次使用
    async{}  // 单次使用

    delay(10000)


}