package com.example.myapplication.factory.simple

object Consumer {
    @JvmStatic
    fun main(args: Array<String>) {
        // 1、传统 new  方式
//        val tesla: Car = Tesla()
//        val wuLing: Car = WuLing()
//
//        tesla.name()
//        wuLing.name()

        // 2、简单工厂模式
        CarFactory.createCar("WuLing").name()
        CarFactory.createCar("Tesla").name()
    }
}
