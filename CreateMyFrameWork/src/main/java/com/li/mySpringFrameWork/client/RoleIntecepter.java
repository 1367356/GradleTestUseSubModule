package com.li.mySpringFrameWork.client;

import com.li.mySpringFrameWork.rule.Intercepter;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 12:12
 *
 * 执行通知之类的。
 **/
public class RoleIntecepter implements Intercepter{
    @Override
    public void before() {
        System.out.println("处理sql之前");
    }

    @Override
    public void after() {
        System.out.println("处理sql之后");
    }
}
