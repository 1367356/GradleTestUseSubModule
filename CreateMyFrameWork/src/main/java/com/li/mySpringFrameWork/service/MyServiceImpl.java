package com.li.mySpringFrameWork.service;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 12:15
 **/
public class MyServiceImpl implements MyService{
    @Override
    public void service() {
        System.out.println("执行服务");
    }

    @Override
    public void select() {
        System.out.println("执行选择语句");
    }
}
