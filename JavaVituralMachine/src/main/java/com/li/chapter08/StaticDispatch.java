package com.li.chapter08;

/**
 * 静态分派
 */
public class StaticDispatch {
    static abstract class Human{

    }

    static class Women extends Human{

    }

    static class man extends Human{

    }
    public void sayHello(Human human) {
        System.out.println("hello,human");
    }

    public void sayHello(Women women) {
        System.out.println("hello, women");
    }

    public void sayHello(man man) {
        System.out.println("hello, man");
    }

    public static void main(String[] args){
        Human human=new man();
        Human women=new Women();

        StaticDispatch staticDispatch=new StaticDispatch();
        staticDispatch.sayHello(human);
        staticDispatch.sayHello(women);

        /**
         * 结果
         * hello,human
         hello,human
         */
    }
}
