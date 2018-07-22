package com.li.ObservePattern.MyDesignPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 08:41
 **/
public class ConcreteObserve2 implements Observe{
    @Override
    public void observe(Subject subject) {
        System.out.println("observe2        "+subject.getState());
    }
}
