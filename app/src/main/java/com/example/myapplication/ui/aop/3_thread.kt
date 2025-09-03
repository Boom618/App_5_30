package com.example.myapplication.ui.aop

import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 *  线程的交互式 结束
 */
fun main() = runBlocking() {

   val thread =  thread{
        println("thread start")
        Thread.sleep(1000)
        println("thread end")

       try {
           Thread.sleep(100)
       } catch (e: InterruptedException) {

       }

       ensureActive()
   }
    // 线程的交互式 结束
    thread.stop()
    thread.interrupt()

}