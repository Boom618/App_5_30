package com.example.myapplication.factory.abstracts;

public class XiaomiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
