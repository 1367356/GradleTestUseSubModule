package com.li.chapter08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * MethodHandle 基础用法演示
 */
public class MethodHandleTest {
    static class ClassA{
        public void println(String s) {
            System.out.println(s);
        }

        public static void main(String[] args) throws Throwable {
            Object obj=System.currentTimeMillis()%2==0?System.out:new ClassA();
            /**
             * 无论obj最终是哪个实现类，下面这句话都能正确调用到pringln方法
             */
            getPrintlnMH(obj).invokeExact("icyfenix");
        }

        private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
            MethodType methodType = MethodType.methodType(void.class, String.class);  //返回类型和参数类型
            return MethodHandles.lookup().findVirtual(receiver.getClass(), "pringln", methodType).bindTo(receiver);
        }
    }
}
