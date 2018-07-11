package com.li.MyProxyPattern;

import java.lang.reflect.Method;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 09:36
 *   代理对象
 **/
public class ProxyObject implements InvocationHandler{
    Object object;
    public Object bind(RealObject realObject) {
        System.out.println("绑定目标对象");
        Object proxy = Proxy.proxy(realObject,this);  //生成代理类，代理类时创建一个文本，输入流，动态生成的。刚开始是不存在的
        object=realObject;
        return object;
    }

    /**
     * 被代理方法
     */
    public void sameOperation() throws Throwable {
        System.out.println("将目标对象的方法交给代理对象执行，代理对象调用invoke()方法");
        invoke(object, object.getClass().getDeclaredMethods()[0],object.getClass().getSigners());
    }

    @Override
    public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {

        System.out.println("调用目标对象方法前");
        var2.invoke(var1);
        System.out.println("调用目标对象方法后");

        return var1;
    }
}
