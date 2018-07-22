package com.li.ObservePattern.MyDesignPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 08:41
 **/
public class Client {

    public static void main(String[] args){
        Subject subject=new Subject();
        ConcreteObservce1 concreteObservce1=new ConcreteObservce1();
        ConcreteObserve2 concreteObserve2=new ConcreteObserve2();

        subject.addObserve(concreteObservce1);
        subject.addObserve(concreteObserve2);

        subject.setState("I am change");

        subject.notifyObservec();

    }
}
