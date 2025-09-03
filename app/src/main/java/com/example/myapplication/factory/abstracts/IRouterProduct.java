package com.example.myapplication.factory.abstracts;

/**
 * 抽象工厂类：路由器 产品接口
 */
public interface IRouterProduct {
    void start();

    void shutdown();

    void openWifi();

    void setting();

}
