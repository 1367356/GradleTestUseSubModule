package com.li.ObservePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 15:58
 **/
public abstract class Subject {
    List<Observe> observes = new ArrayList<>();

    String state;

    public String getState() {
        return state;
    }

    /**
     * 添加一个观察者
     * @param observe
     */
    public void addObserver(Observe observe) {
        observes.add(observe);
    }

    public void removeObserve(Observe observe) {
        observes.remove(observe);
    }

    public void change(String state) {
        this.state=state;
    }

    /**
     * 通知所有观察者
     */
    public void notifyObservers() {
        for (Observe observe : observes) {
            observe.pullupdate(this);
        }
    }



}
