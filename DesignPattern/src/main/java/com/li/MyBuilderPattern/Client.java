package com.li.MyBuilderPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:28
 **/
public class Client {
    public static void main(String[] args){
        Builder builder=new ConcreteBuilder1();
        Director director = new Director(builder);
        Product result = director.construct("part1", "part2");
        System.out.println(result.getPart1());
        System.out.println(result.getPart2());
    }
}
