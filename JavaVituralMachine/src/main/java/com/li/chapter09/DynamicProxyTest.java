package com.li.chapter09;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello{
        void sayHello();
    }
    interface IHello2{
        void sayHello2();
    }

    static class Hello implements IHello,IHello2{
        @Override
        public void sayHello() {
            System.out.println("Hello world");
        }

        @Override
        public void sayHello2() {
            System.out.println("Hello world 2");
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

        IHello2 hello2 = (IHello2) new DynamicProxy().bind(new Hello());   //
        hello2.sayHello2();
    }

}
