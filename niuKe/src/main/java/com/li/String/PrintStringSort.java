package com.li.String;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-21 15:49
 * Java 中，怎么打印出一个字符串的所有排列
 **/
public class PrintStringSort {
    public static void main(String[] args){
        String str="abcd";
        char[] chars = str.toCharArray();
        int low=0;

        for (int i = 0; i <chars.length; i++) {
            char temp = chars[i];
            chars[i]=chars[0];
            chars[0]=temp;
            print(chars,low);
        }
    }

    private static void print(char[] chars, int low) {

        if (low == chars.length-1) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println("");
        }
        for (int i = low+1; i < chars.length; i++) {
            char temp=chars[i];
            chars[i] = chars[low+1];
            chars[low+1]=temp;

            print(chars,low + 1);

            char temp1=chars[i];
            chars[i] = chars[low+1];
            chars[low+1]=temp1;
        }
    }
}
