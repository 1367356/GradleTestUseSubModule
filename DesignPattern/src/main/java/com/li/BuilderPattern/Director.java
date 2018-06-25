package com.li.BuilderPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 16:21
 **/
public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     *
     * 产品构造方法，负责调用各个零件建造方法
     *
     */
    public void build() {
        builder.builderPart1();
        builder.builderPart2();
    }
}
