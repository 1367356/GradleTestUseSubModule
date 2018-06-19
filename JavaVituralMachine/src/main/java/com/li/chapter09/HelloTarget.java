package com.li.chapter09;

public class HelloTarget implements HelloProxy{
    @Override
    public void sayHello() {
        System.out.println("hello target");
    }
}
