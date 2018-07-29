package com.li.mySpringFrameWork.client;

import com.li.mySpringFrameWork.rule.AopUtils;
import com.li.mySpringFrameWork.rule.Intercepter;
import com.li.mySpringFrameWork.service.MyService;
import com.li.mySpringFrameWork.service.MyServiceImpl;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 12:11
 **/
public class Main {
    public static void main(String[] args){
        MyService myService=new MyServiceImpl();
        Intercepter intercepter=new RoleIntecepter();

        AopUtils<MyService> aopUtils=new AopUtils<MyService>();
        MyService proxyClass = aopUtils.getBean(myService, intercepter);

        proxyClass.select();
    }
}
