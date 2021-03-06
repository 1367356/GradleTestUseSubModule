package com.li.chapter08;

/**
 * 动态分派
 */
public class DynamicDispatch {
    static abstract class Human{
        protected abstract void sayHello();
    }
    static class Man extends Human{

        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }
    static class Woman extends Human{

        @Override         //覆盖
        protected void sayHello() {
            System.out.println("Woman say hello");
        }
    }

    public static void main(String[] args){
        Human man=new Man();
        Human woman=new Woman();

        man.sayHello();
        woman.sayHello();

        man=new Woman();
        man.sayHello();
        /**
         * man say hello
         Woman say hello
         Woman say hello
         */
    }
}
