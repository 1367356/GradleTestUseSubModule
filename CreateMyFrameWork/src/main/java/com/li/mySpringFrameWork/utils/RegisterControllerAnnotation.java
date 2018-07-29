package com.li.mySpringFrameWork.utils;

import com.li.mySpringFrameWork.httpServerAsController.MyController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 18:39
 **/
public class RegisterControllerAnnotation {
    Map<String,Map<Method,Class>> controllerInjectToMap = new HashMap();
    public static void main(String[] args){
        RegisterControllerAnnotation mainClass=new RegisterControllerAnnotation();
        mainClass.controllerPathInjectToMap(MyController.class);
    }

    /**
     * 将注解CotrollerMappingAnnotation的映射值添加到map中，通信时查询
     * @param cl
     */
    public void controllerPathInjectToMap(Class cl) {
        for (Method m : cl.getDeclaredMethods()) {  //根据Class名称获得定义的方法，得到该类的方法
            System.out.println(m.getName());
            //得到各个方法上的CotrollerMappingAnnotation 注解
            CotrollerMappingAnnotation cma = m.getAnnotation(CotrollerMappingAnnotation.class);  //根据方法得到用在该方法上的注解。指定注解类名，就得到该类的注解。否则可以得到多个注解

            //将注解注入到map中
            Map<Method, Class> map = new HashMap<>();
            map.put(m, cl);
            controllerInjectToMap.put(cma.mappingPath(),map);
        }
    }

    public Map<String, Map<Method, Class>> getControllerInjectToMap() {
        return controllerInjectToMap;
    }

    public void setControllerInjectToMap(Map<String, Map<Method, Class>> controllerInjectToMap) {
        this.controllerInjectToMap = controllerInjectToMap;
    }
}
