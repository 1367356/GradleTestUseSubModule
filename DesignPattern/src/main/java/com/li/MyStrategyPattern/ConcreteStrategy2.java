package com.li.MyStrategyPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:08
 **/
public class ConcreteStrategy2 implements Stategy{
    @Override
    public int strategy(int count) {
        return (int) (count*0.5);
    }
}
