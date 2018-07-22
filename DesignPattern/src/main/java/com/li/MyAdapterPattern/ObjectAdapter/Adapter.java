package com.li.MyAdapterPattern.ObjectAdapter;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:55
 **/
public class Adapter implements Target{

    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operation1() {
        adaptee.operation1();
    }

    @Override
    public void operation2() {
         //相关业务代码的实现
    }
}
