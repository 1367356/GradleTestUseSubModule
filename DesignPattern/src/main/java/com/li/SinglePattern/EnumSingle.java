package com.li.SinglePattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-11 09:45
 **/// Effective Java 第二版推荐写法

public enum EnumSingle {

    INSTANCE;

    public void fun1() {

        // do something

    }

}


class test{
    public void test() {
        // 使用
        EnumSingle.INSTANCE.fun1();
    }
}

