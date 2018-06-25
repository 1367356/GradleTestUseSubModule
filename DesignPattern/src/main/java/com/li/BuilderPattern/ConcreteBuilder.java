package com.li.BuilderPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 16:19
 * 具体的建造者
 **/
public class ConcreteBuilder implements Builder{

    Product product=new Product();

    @Override
    public void builderPart1() {
        product.setPart1("part1");
    }

    @Override
    public void builderPart2() {
        product.setPart2("part2");
    }

    @Override
    public Product constructor() {
        return product;
    }
}
