package com.li;

import org.junit.Test;

/**
 * 字符串的排列
 */
public class Question28 {

    @Test
    public void test() {
        char[] str = {'a', 'b', 'c','d','0'};
        permutation(str);
    }

    public void permutation(char[] str) {
        if (str == null) {
            return;
        }
        sortString(str,str[0],0);
    }

    /**
     * 使用递归对字符数组的全排列进行打印。
     * a和b换，打印出来一个，b和c换，再打印一个。
     * @param str
     * @param begin
     * @param index
     */
    public void sortString(char[] str, char begin,int index) {
        if(begin=='0'){
            System.out.println(str);
        }else {
            for (int i = index; i < str.length-1; i++) {   //循环递归
                    char temp= str[index];
                    str[index]= str[i];
                    str[i] = temp;
                    sortString(str,str[index+1],index+1);
                    char temp1=str[index];
                    str[index]= str[i];
                    str[i]=temp1;
            }
        }
    }

}
