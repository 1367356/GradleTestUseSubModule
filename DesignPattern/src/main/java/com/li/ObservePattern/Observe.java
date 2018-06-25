package com.li.ObservePattern;


/**
 * 提供一个观察者接口
 */
public interface Observe {
    void pullupdate(Subject subject);  //拉模型，将主题直接传递给观察者

    void pushupdate(String state);    //推模型，传递主题改变的状态

}
