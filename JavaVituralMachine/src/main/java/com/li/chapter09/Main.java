package com.li.chapter09;

public class Main {
    public static void main(String[] args){
        DynamicProxy dynamicProxy=new DynamicProxy();
        HelloProxy helloProxy= (HelloProxy) dynamicProxy.bind(new HelloTarget());
        helloProxy.sayHello();
    }
}
