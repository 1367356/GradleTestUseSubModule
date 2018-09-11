package com.li.exam360;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 数据
 5 3
 1 2 3 2 2  -- 数值
 3
 1 4  -- 区间
 2 4
 1 5
计算指定区间，有不同的数值
 */
public class Main1 {
public static void main(String[] args){
    Class clazz = Main1.class.getClass();
    InputStream ins = Main1.class.getResourceAsStream("/jinRiTouTiao/question5.txt");
    Scanner scanner = new Scanner(ins);

    int n=scanner.nextInt();
    int m=scanner.nextInt();
    int[] arri = new int[n];
    for (int i = 0; i < n; i++) {
        arri[i]=scanner.nextInt();
    }

    int[][] arrs = new int[n][n];
    for (int i = 0; i < n; i++) {
        Set<Integer> set = new HashSet();
        for (int j = i; j < n; j++) {
            set.add(arri[j]);
            arrs[i][j]=set.size();
        }
    }

    int q=scanner.nextInt();
    for (int i = 0; i < q; i++) {
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        System.out.println(arrs[row-1][col-1]);
    }

}

}
