package com.li.MyStrategyPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:08
 **/
public class Context {
    private Stategy stategy;

    public Stategy getStategy() {
        return stategy;
    }

    public void setStategy(Stategy stategy) {
        this.stategy = stategy;
    }

    public int count(int count) {
        return stategy.strategy(count);
    }

}
