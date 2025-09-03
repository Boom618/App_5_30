package com.example.myapplication.factory.abstracts;

/**
 * 核心：
 * 抽象产品工厂： 可以理解为 【抽象的抽象】
 * 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 */
public interface IProductFactory {

    // 抽象手机产品
    IPhoneProduct iphoneProduct();

    // 抽象路由产品
    IRouterProduct routerProduct();

    // 添加新产品族，先增加产品接口，如：平板产品
}
