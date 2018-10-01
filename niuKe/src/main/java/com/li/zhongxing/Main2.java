package com.li.zhongxing;


import java.io.InputStream;
import java.util.Scanner;

/**
 * m f g h n 能组成的含有3个字符的不同的组合的个数。
 */
public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/zhongxing/data2.txt");
        Scanner scanner = new Scanner(Systemin);

        char[] chars = {'a', 'd', 'r'};
        int index=0;
//        for (int j = 0; j < chars.length; j++) {
//            swap(chars,0, j);
            recursive(chars,index);
//        }
    }

    private static void swap(char[] chars,int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j]=temp;
    }

    private static void recursive(char[] chars,int index){
        if (index == 3) {
            for (int i = 0; i < 3; i++) {
                System.out.print(chars[i]);
            }
            System.out.println("");
            return;
        }

        for (int i = index; i < chars.length; i++) {
            char temp = chars[i];
            chars[i]=chars[index];
            chars[index]=temp;

            recursive(chars,index+1);

            char temp1 = chars[i];
            chars[i]=chars[index];
            chars[index]=temp1;
        }
    }
}
