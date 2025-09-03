package com.example.myapplication.factory.abstracts;

public class HuaweiPhone implements IPhoneProduct {

    @Override
    public void start() {
        System.out.println("Huawei Phone is starting...");
    }

    @Override
    public void shutdown() {
        System.out.println("Huawei Phone is shutting down...");

    }

    @Override
    public void callUp() {
        System.out.println("Huawei Phone is calling up...");

    }

    @Override
    public void sendSMS() {
        System.out.println("Huawei Phone is sending SMS...");
    }
}
