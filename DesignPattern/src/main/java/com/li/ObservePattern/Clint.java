package com.li.ObservePattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 16:06
 **/
public class Clint {
    public static void main(String[] args){
        ConcreteSubject subject=new ConcreteSubject();
        subject.setState("hello");

        Observe observe=new Observer1();
        subject.addObserver(observe);
        subject.notifyObservers();
    }
}
