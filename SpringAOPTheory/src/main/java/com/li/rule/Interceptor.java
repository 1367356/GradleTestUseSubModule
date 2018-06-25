package com.li.rule;

/**
 * 约定规则,
 * 创建一个拦截接口
 */
public interface Interceptor {
    public void before(Object object);
    public void after(Object object);
    public void afterRturning(Object object);
    public void afterThrowing(Object object);
}
