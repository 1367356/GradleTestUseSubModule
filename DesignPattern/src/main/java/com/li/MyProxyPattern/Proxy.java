package com.li.MyProxyPattern;

import java.lang.reflect.Method;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 10:00
 * 为代理方法生成一个代理类
 **/
public class Proxy<T> {
    static Object proxyObject;  //应该包含被代理方法，和另外三个方法
    static Object proxy(Object object, InvocationHandler invocationHandler){  //加目标对象的接口
        proxyObject=object;





        return object;
    }


    class subclass{

    }
    public T createObject() {

        T t=null;
        return t;
    }


    /**
     * 被代理方法
     */
    public void sameOperation() throws Throwable {
        System.out.println("将目标对象的方法交给代理对象执行，代理对象调用invoke()方法");
        invoke(proxyObject, proxyObject.getClass().getDeclaredMethods()[0],proxyObject.getClass().getSigners());
    }

    public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {

        System.out.println("调用目标对象方法前");
        var2.invoke(var1);
        System.out.println("调用目标对象方法后");

        return var1;
    }


}
