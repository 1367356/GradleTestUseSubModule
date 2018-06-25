package com.li.rpc;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-23 09:50
 **/
public class HelloServiceImpl  implements HelloService{
    @Override
    public String sayHi(String name) {
        return "hi"+name;
    }
}
