package com.example.myapplication.factory.abstracts;

public class HuaWeiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new HuaweiRouter();
    }

}
