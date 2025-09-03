package com.example.myapplication.factory.mether

class TeslaFactory : CarFactory {
//    fun getCar(): Car {
//        // 创建特斯拉汽车实例
//        return Tesla()
//    }


    // override val car = Tesla()
    override val car: Car
        get() = Tesla()
}
