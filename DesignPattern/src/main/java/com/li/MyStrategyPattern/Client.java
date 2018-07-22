package com.li.MyStrategyPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:08
 **/
public class Client {


    public static void main(String[] args){
        int price=100;
        Stategy stategy=new ConcreteStrategy2();
        Context context=new Context();
        context.setStategy(stategy);
        int count = context.count(price);
        System.out.println(count);
    }
}
