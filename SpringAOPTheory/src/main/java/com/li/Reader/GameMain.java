package com.li.Reader;

import com.li.model.Role;
import com.li.rule.Interceptor;
import com.li.rule.ProxyBeanFactory;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 17:55
 **/
public class GameMain {
    public static void main(String[] args){
        RoleService roleService=new RoleServiceImpl();
        Interceptor interceptor=new RoleInterceptor();                            //拦截器，也是框架提供的，背后使用了动态代理和反射

        //获得bean对象的动态代理
        RoleService proxy = ProxyBeanFactory.getBean(roleService, interceptor);   // 获取一个代理对象，框架提供的，在author中，  将自己实现的拦截器提供给框架
        Role role=new Role((long) 1,"roleName","note");

        proxy.printRole(role);  //执行方法，author中的动态代理invoke执行 ，将要执行的方法织入到动态代理invoke响应的位置，前后固定的逻辑由interceptor执行。使人专注于业务。

        //从以上代码和结果可以看出，我们并没有显示的调用invoke()方法，但是这个方法确实执行了。下面就整个的过程进行分析一下：
       // https://blog.csdn.net/wang_1997/article/details/52450549
    }
}
