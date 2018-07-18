package com.li.String;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-18 09:23
 **/
public class StringIntern {
    public static void main(String[] args){
        String s1 = "ram1";
        String s2 = "ram1";
        System.out.println(s1 == s2);  //true，  String 放到常量池中（方法区的一部分），当创建String常量时，会先检查常量池中是否已经存在，如果不存在，才创建。
                                     //String intern  可以运行时创建String 常量，
// jdk1.7之后String intern的区别 ,简单的说其实就一个：在jdk1.7之前，字符串常量存储在方法区的PermGen Space。在jdk1.7之后，字符串常量重新被移到了堆中。

        String s3 = new String("ram3");
        String s4 = new String("ram3");
        System.out.println(s3 == s4);  //false

        String s5 = s3.intern();
        System.out.println(s5==s3);  //false
        String s6=s4.intern();
        System.out.println(s5==s6);  //true

        String str = new StringBuilder("ja").append("va").toString();
        System.out.println(str.intern()==str);//false

        String st2=new StringBuilder("计算机").append("软件").toString();
        System.out.println(st2.intern()==st2);

        String st3=new StringBuilder("计算机").append("软件").toString();
        System.out.println(st3.intern()==st3);
        System.out.println(st3.intern()==st2);
        /**结果
         true
         false
         true
         */
    }
}
