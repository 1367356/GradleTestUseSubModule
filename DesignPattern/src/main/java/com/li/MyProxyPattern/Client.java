package com.li.MyProxyPattern;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 09:53
 **/
public class Client {
    public static void main(String[] args) throws Throwable {
        ProxyObject proxyObject=new ProxyObject();
        proxyObject.bind(new RealObject());

    }
}
