package com.example.myapplication.factory.abstracts

object Client {
    @JvmStatic
    fun main(args: Array<String>) {
        println("================ Xiaomi is product...")

        val xiaomiFactory = XiaomiFactory()

        val iPhoneProduct = xiaomiFactory.iphoneProduct()
        iPhoneProduct.start()
        iPhoneProduct.callUp()

        val iRouterProduct = xiaomiFactory.routerProduct()
        iRouterProduct.start()
        iRouterProduct.openWifi()

        println("================ Huawei is product...")

        val huaweiFactory = HuaWeiFactory()

        val phoneProduct = huaweiFactory.iphoneProduct()
        phoneProduct.start()
        phoneProduct.callUp()

        val routerProduct = huaweiFactory.routerProduct()
        routerProduct.start()
        routerProduct.openWifi()
    }
}
