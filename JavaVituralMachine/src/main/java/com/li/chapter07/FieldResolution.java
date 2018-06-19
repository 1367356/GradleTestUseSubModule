package com.li.chapter07;

/**
 * 字段解析
 */
public class FieldResolution {

    interface Interface0{
        int A=0;
    }

    interface interface1 extends Interface0{
        int A=1;
    }

    interface Interface2{
        int A=2;
    }

    static class Parent implements interface1{
        public static int A=3;
    }

}
