package com.li.ObservePattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 16:05
 * 接口自定义接口，不定义状态，具体的实现类，定义具体的状态
 **/
public class ConcreteSubject extends Subject {

    public void setState(String state) {
        this.state=state;
    }
}
