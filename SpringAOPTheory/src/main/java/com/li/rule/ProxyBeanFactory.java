package com.li.rule;

import com.li.Author.ProxyBeanutil;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 17:39
 *   约定规则
 *  生成对象时，都用这样的一个类去生成对应的对象。
 *  getBean方法
 *  创建Bean
 *
 *  ProxyBeanFactory  作为客户端和框架的中介
 **/
public class ProxyBeanFactory {
    public static <T> T getBean(T obj, Interceptor interceptor) {
        return (T) ProxyBeanutil.getBean(obj, interceptor);  //ProxyBeanutil  是由开发框架的人员提供
    }
}
