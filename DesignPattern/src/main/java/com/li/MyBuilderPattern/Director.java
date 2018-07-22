package com.li.MyBuilderPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:21
 *  导演者
 **/
public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder=builder;
    }

    public Product construct(String part1,String part2) {
        builder.build1(part1);
        builder.build2(part2);
        return builder.retriveResult();
    }
}
