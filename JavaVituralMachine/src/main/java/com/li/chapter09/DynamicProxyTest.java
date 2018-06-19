package com.li.chapter09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello{

        @Override
        public void sayHello() {
            System.out.println("Hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler{

        Object originalObj;  //对象
        Object bind(Object originalObj){ //绑定目标对象
            this.originalObj=originalObj;
            //返回代理实例
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, objects);  //调用目标对象方法
        }
    }

    public static void main(String[] args){
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());   //
        hello.sayHello();
    }

}
