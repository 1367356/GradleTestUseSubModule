package com.li.wangYi;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-21 15:49
 * Java 中，怎么打印出一个字符串的所有排列
 **/
public class Ques3 {
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args){
        String str="aaazzz";
        char[] chars = str.toCharArray();
        int low=0;

        for (int i = 0; i <chars.length; i++) {
            char temp = chars[i];
            chars[i]=chars[0];
            chars[0]=temp;
            print(chars,low);
        }

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void print(char[] chars, int low) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
        }
        set.add(stringBuffer.toString());
        stringBuffer=null;
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
