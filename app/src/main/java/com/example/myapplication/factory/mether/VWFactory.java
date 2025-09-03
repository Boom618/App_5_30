package com.example.myapplication.factory.mether;

import androidx.annotation.NonNull;

public class VWFactory implements CarFactory {
    @NonNull
    @Override
    public Car getCar() {
        return new VW();
    }
}
