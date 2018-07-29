package com.li.mySpringFrameWork.rule;

import com.li.mySpringFrameWork.FrameWork.DynamicProxyClass;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 12:00
 **/
public class AopUtils<T>{
    public T getBean(T object,Intercepter intercepter) {
        DynamicProxyClass dynamicProxyClass=new DynamicProxyClass();
        T proxy = (T) dynamicProxyClass.bind(object,intercepter);
        return proxy;
    }
}
