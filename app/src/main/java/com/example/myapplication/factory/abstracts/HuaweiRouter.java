package com.example.myapplication.factory.abstracts;

public class HuaweiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("Huawei Router is starting...");
    }

    @Override
    public void shutdown() {
        System.out.println("Huawei Router is shutting down...");

    }

    @Override
    public void openWifi() {
        System.out.println("Huawei Router is opening WIFI...");

    }

    @Override
    public void setting() {
        System.out.println("Huawei Router is setting...");

    }
}
