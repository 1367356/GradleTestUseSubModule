package com.li.chapter09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

    Object original;

    Object bind(Object target) {
        this.original=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);  //this 是 DynamicProxy
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("before");
        return method.invoke(original,objects);

    }
}
