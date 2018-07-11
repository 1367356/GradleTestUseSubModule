package com.li.chapter08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-01 20:51
 *
 *  使用MethodHandle来解决相关问题
 **/
public class Test {

    class GrandFather{
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather{
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father{
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);  //参数为空
                MethodHandle mh = lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());  //获取方法对象,findSpecial对应findspcial指令
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        (new Test().new Son()).thinking();
    }
}
