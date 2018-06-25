package com.li.ObservePattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 16:03
 **/
public class Observer1 implements Observe {
    @Override
    public void pullupdate(Subject subject) {
        System.out.println(subject.getState());
    }

    @Override
    public void pushupdate(String state) {

    }
}
