package com.li.mySpringFrameWork.httpServerAsController;

import com.li.mySpringFrameWork.utils.CotrollerMappingAnnotation;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-29 16:08
 **/
public class MyController {

    @CotrollerMappingAnnotation(mappingPath = "/index/1")
    public String index1(String name,String password) {
        System.out.println("调用 1"+name);
        return "name:"+name+"password:"+password;
    }
    @CotrollerMappingAnnotation(mappingPath = "/index/2")
    public void index2() {
        System.out.println("2");
    }
    @CotrollerMappingAnnotation(mappingPath = "/hello/mapping")
    public void index3() {
        System.out.println("我是映射/hello/mapping,我被调用了");
    }
}
