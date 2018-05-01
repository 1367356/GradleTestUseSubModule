package com.li;

import org.junit.Test;

/**
 * 把字符串转换成整数。
 */
public class Question49 {

    boolean minus=false;  //判断是否是负值
    public boolean invalid=false; //输入是否是字符串0
    public int strToInt(String string) throws InterruptedException {
        int num=0;
        if (string == null) {
            return 0;
        }
        if(string.length()==1&&string=="0"){
            invalid=true;
            return 0;
        }
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)<='9'&&string.charAt(i)>='0'){
                char c = string.charAt(i);
                num=num*10+c-'0';   //最后要减去0
            }else {
                if(i==0&&string.charAt(i)=='-'){
                    minus=true;
                }else {
                    throw new InterruptedException("不能转化为整数,不能转化为字符串。");
//                    num=0;  //如果不能转化为整数
//                    break;
                }
            }
        }
        if (minus) {
            num=0-num;
        }
        return num;
    }

    @Test
    public void test() throws InterruptedException {
        int i = strToInt("-64636");
        if (invalid&&i==0) {
            System.out.println("字符串0");
        } else if (!invalid && i == 0) {
            System.out.println("空值0");
        }else {
            System.out.println(i);
        }
    }
}
