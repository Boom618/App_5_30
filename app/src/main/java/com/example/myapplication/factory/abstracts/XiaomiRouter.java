package com.example.myapplication.factory.abstracts;

public class XiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("XiaomiRouter start");
    }

    @Override
    public void shutdown() {
        System.out.println("XiaomiRouter shutdown");

    }

    @Override
    public void openWifi() {
        System.out.println("XiaomiRouter openWifi");

    }

    @Override
    public void setting() {
        System.out.println("XiaomiRouter setting");

    }
}
