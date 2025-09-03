package com.example.myapplication.factory.abstracts;

public class XiaomiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("xiaomi phone start");
    }

    @Override
    public void shutdown() {
        System.out.println("xiaomi phone shutdown");
    }

    @Override
    public void callUp() {
        System.out.println("xiaomi phone call up");
    }

    @Override
    public void sendSMS() {
        System.out.println("xiaomi phone send sms");
    }
}
