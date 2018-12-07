package com.cn.service.proxy;

public class IPerson implements Person {
    @Override
    public void eat() {
        System.out.println("i am eating...");
    }

    @Override
    public void sleep() {
        System.out.println("i am sleeping...");
    }
}
