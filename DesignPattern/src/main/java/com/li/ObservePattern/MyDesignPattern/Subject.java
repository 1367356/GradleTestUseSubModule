package com.li.ObservePattern.MyDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 08:54
 **/
public class Subject {
    private String state;


    List<Observe> list = new ArrayList<>();
    public void addObserve(Observe observe) {
        list.add(observe);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void notifyObservec() {
        for (Observe observe : list) {
            observe.observe(this);
        }
    }
}
