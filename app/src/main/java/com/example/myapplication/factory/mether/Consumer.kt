package com.example.myapplication.factory.mether

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
//        CarFactory.createCar("WuLing").name()
//        CarFactory.createCar("Tesla").name()

        // 3、工厂方法模式
        TeslaFactory().car.name()
        WuLingFactory().car.name()
        // 3.1  增加一个大众车型 ，对 CarFactory 原有代码没有影响
        VWFactory().car.name()

        // 4、抽象工厂模式

    }
}
