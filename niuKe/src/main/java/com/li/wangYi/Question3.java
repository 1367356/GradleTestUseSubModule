package com.li.wangYi;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-10 18:53
 **/
public class Question3 {
    public static void main(String[] args){

        Class clazz = Question3.class.getClass();
        /**
         * txt文件中，例如  1 2 4 8 8    1是起始节点，2 相邻节点，4是1,2之间的权重，8是相邻节点，8是1,8之间的权重。
         */
        InputStream ins = clazz.getResourceAsStream("/month9day16/wangYi/question3.txt");
        Scanner scanner = new Scanner(ins);

        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();

        if (n * m > 2 * k) {
            System.out.println(-1);
            return;
        }

        char[] chars = new char[n + m];

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
        }
        for (int i = 0; i < m; i++) {
            chars[i + n] = 'z';
        }
        System.out.println(Arrays.toString(chars));
        //递归一次打印一次
        recursive(chars);
    }

    static int k=6;
    private static void recursive(char[] chars) {
        k--;
        if(k<0){
            System.out.println("");
        }
    }



    //aazz ,azaz,azza,zaaz,zaza,zzaa.
    //aaazzz, aazazz
}
