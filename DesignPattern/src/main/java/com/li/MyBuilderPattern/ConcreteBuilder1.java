package com.li.MyBuilderPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 09:19
 **/
public class ConcreteBuilder1 implements Builder{

    Product product=new Product();
    @Override
    public void build1(String part1) {
        product.setPart1(part1);
    }

    @Override
    public void build2(String part2) {
        product.setPart2(part2);
    }

    @Override
    public Product retriveResult() {
        return product;
    }
}
