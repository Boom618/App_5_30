package com.example.myapplication.ui.context

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatchers.IO + Job()  // + 号，是一个操作符
 *
 *
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking() {

    val scope = CoroutineScope(Dispatchers.IO + Job())

    Job() + Dispatchers.IO + Job()
    // 同类型的 不能使用 + 号
   //  Job() + Job()
   //  Dispatchers.IO + Dispatchers.IO

    scope.launch() {


    }

    delay(10000)

}
