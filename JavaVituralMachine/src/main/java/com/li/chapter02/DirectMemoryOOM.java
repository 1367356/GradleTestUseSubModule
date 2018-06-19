package com.li.chapter02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFiled = Unsafe.class.getDeclaredFields()[0]; //获取方法中定义的域
        unsafeFiled.setAccessible(true);  //是否能用
        Unsafe unsafe= (Unsafe) unsafeFiled.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);

            /**
             * 结果
             * Exception in thread "main" java.lang.OutOfMemoryError
             at sun.misc.Unsafe.allocateMemory(Native Method)
             at com.li.chapter02.DirectMemoryOOM.main(DirectMemoryOOM.java:18)
             */
        }
    }
}
