package com.li.ObservePattern.MyDesignPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 08:40
 **/
public class ConcreteObservce1 implements Observe{
    @Override
    public void observe(Subject subject) {
        System.out.println("observe1    "+subject.getState());
    }
}
