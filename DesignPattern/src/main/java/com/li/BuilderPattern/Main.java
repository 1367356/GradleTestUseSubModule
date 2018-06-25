package com.li.BuilderPattern;

import com.li.ObservePattern.ConcreteSubject;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 16:23
 **/
public class Main {
    public static void main(String[] args){
        ConcreteBuilder builder=new ConcreteBuilder();
        Director director = new Director(builder);

        director.build();

        Product product=builder.constructor();

        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
