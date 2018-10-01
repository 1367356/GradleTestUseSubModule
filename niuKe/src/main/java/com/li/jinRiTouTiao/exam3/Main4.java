package com.li.jinRiTouTiao.exam3;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-09 09:55
 **/
public class Main4 {
    public static void main(String[] args){
        Class clazz = Main4.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/jinRiTouTiao/exam3/question4.txt");
        Scanner scanner = new Scanner(ins);
        int Num = scanner.nextInt();
        int[] arrs = new int[Num];
        for (int j = 0; j < Num; j++) {
            arrs[j]=scanner.nextInt();
        }
        boolean num = isUTF8(arrs);
        if (num) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }


    private static int countNum(int[] data, int i) {
        int ma = 128;   // 00000000 00000000 00000000 10000000
        int count = 0;
        for(int j = 0; j < 8; j++) {
            if((ma & data[i]) == 0) {
                break;
            }
            count++;
            ma >>= 1;
        }
        return count;
    }

    public static boolean isUTF8(int[] datas) {
        if(datas == null || datas.length == 0) {
            return false;
        }
        int i = 0;
        while(i < datas.length) {
            int c = countNum(datas, i);
            if(c == 1 || c > 4) {
                return false;
            }
            if(c == 0) {
                i++;
            }else if(c == 2) {
                if(i + 1 >= datas.length || countNum(datas, i + 1) != 1) {
                    return false;
                }
                i += 2;
            }else if(c == 3) {
                if(i + 2 >= datas.length || countNum(datas, i + 1) != 1 || countNum(datas, i + 2) != 1 ) {
                    return false;
                }
                i += 3;
            }else {
                if(i + 3 >= datas.length || countNum(datas, i + 1) != 1 || countNum(datas, i + 2) != 1 || countNum(datas, i + 3) != 1 ) {
                    return false;
                }
                i += 4;
            }
        }
        return true;
    }
}
