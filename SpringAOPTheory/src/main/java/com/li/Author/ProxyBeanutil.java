package com.li.Author;

import com.li.Reader.RoleService;
import com.li.rule.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-25 17:43
 **/
public class ProxyBeanutil implements InvocationHandler{



    //被代理的对象
    private Object obj;

    //reader（程序员）配置的拦截器
    private Interceptor interceptor=null;


    /**
     * 获取代理对象
     * @param obj  真实对象
     * @param interceptor  配置的拦截器，传到该bean中，  这比单纯的动态代理，多了一个拦截器。  这样程序员只需要实现一个拦截器就行了，不用自己实现动态代理了，因为动态代理太难了。
     * @param <T>  泛型
     * @return
     */
    public static <T> Object getBean(T obj, Interceptor interceptor) {
        //使用当前类作为代理方法，此时被代理对象执行方法的时候，会进入当前类的invoke方法里
        ProxyBeanutil _this=new ProxyBeanutil();
        //保存被代理对象
        _this.obj=obj;

        //保存拦截器
        _this.interceptor=interceptor;

        //_this中含有obj,intercepter实现了Interceptor

        //生成代理对象，并绑定代理方法
//        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
        RoleService o = (RoleService) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
        return o;

        /**
         *  通过代理类工厂生产代理类实例，  com.sun.proxy.$Proxy下面的方法给到代理类中，真实对象方法给到代理类中。当调用真实对象方法时，会调用com.sun.proxy.$Proxy 父类中的invoke方法， 即 invocationHandler中的invoke方法。即下面的invoke方法
         if (var16 == null) {
         var16 = "com.sun.proxy.";
         }

         long var19 = nextUniqueNumber.getAndIncrement();
         String var23 = var16 + "$Proxy" + var19;
         byte[] var22 = ProxyGenerator.generateProxyClass(var23, var2, var17);

         try {
         return Proxy.defineClass0(var1, var23, var22, 0, var22.length);

         》》》 public static byte[] generateProxyClass(final String var0, Class<?>[] var1, int var2)
         */
    }

    /**
     * A method invocation on a proxy instance through one of its proxy interfaces will be dispatched to the invoke method of the instance's invocation handler,
     passing the proxy instance,a java.lang.reflect.Method object identifying the method that was invoked, and an array of type Object containing the arguments.
     * @param proxy   代理类实例，动态代理创建对象之后，代理类实例就是proxy,自动传入
     * @param method  代理类调用的方法
     * @param objects  代理类方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        Object retObj=null;
        //是否产生异常
        boolean exceptionFlag=false;
        //before方法
        interceptor.before(obj);


        try {
            //反射原有方法
            retObj = method.invoke(obj, objects);

        }catch (Exception e){
            exceptionFlag=true;
        }finally {
            interceptor.after(obj);
        }

        if (exceptionFlag) {
            //afterThrowing方法
            interceptor.afterThrowing(obj);
        }else{
            //afterReturing 方法
            interceptor.afterRturning(obj);
        }
        return retObj;
    }
}
