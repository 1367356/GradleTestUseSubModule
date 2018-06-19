package com.li.chapter08;

public class Overload {
    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

//    public static void sayHello(char arg) {
//        System.out.println("hello char");
//    }

    public static void main(String[] args){
        char c = 'a';
        sayHello(c);  //hello char

        //注释掉（char arg）  hello int
    }
}
