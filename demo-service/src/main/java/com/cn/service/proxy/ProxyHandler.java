package com.cn.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }

    public static void main(String[] args){
        Person person = new IPerson();

        InvocationHandler handler = new ProxyHandler(person);

        Person p = (Person) Proxy.newProxyInstance(handler.getClass().getClassLoader(), IPerson.class.getInterfaces(), handler);

        p.eat();
        p.sleep();
    }
}
