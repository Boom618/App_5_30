package com.example.myapplication.factory.simple;

/**
 * 简单工厂模式
 * 如果需要添加 大众 车型，需要添加一个 大众 类，并在工厂方法中添加 case ，破坏了 开闭原则；对修改关闭，扩展开闭;。
 */
public class CarFactory {

    public static Car createCar(String type) {
        switch (type) {
            case "WuLing":
                return new WuLing();
            case "Tesla":
                return new Tesla();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}
