package com.li.Reader;

import com.li.rule.Interceptor;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 17:53
 *
 *  拦截器处理了一些公用的部分。例如在before里面建立数据库连接，
 *  发生异常，就在afterThrowing中执行。
 *  拦截器会传递给动态代理
 **/
public class RoleInterceptor implements Interceptor{
    @Override
    public void before(Object object) {
        System.out.println("打印角色信息之前"+object.getClass());
    }

    @Override
    public void after(Object object) {
            System.out.println("已经完成角色信息的打印处理");
    }

    @Override
    public void afterRturning(Object object) {
        System.out.println("刚刚完成打印功能，一切正常");
    }

    @Override
    public void afterThrowing(Object object) {
            System.out.println("打印出现异常");
    }
}
