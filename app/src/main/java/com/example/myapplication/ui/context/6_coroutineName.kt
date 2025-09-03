package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * CoroutineName
 *
 * 类似 Thread name
 *
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking() {

    val scope = CoroutineScope(Dispatchers.IO)
    val name = CoroutineName("CoroutineName")

    scope.launch(name) {


    }

    delay(10000)

}
