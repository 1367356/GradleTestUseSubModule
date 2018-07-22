package com.li.MyFactoryPatern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 10:02
 **/
public class ConcreteFactory1<T> implements Factory<T>{
    @Override
    public T factory(T t) {

        return t;
    }
}
