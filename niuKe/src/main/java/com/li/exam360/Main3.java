package com.li.exam360;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数据：
 5
 1 2 3 4 5
 5 2 3 4 1
指定两个数C[i],C[j]
 如果在A中，C[i] 在C[j]的右边，那么在B中，C[i]也应该在C[j]的右边 .长度加1  。求长度

 答案：3
 */
public class Main3 {
public static void main(String[] args){
    Class clazz = Main3.class.getClass();
    InputStream ins = Main3.class.getResourceAsStream("/jinRiTouTiao/question6.txt");
    Scanner scanner = new Scanner(ins);

    int n=scanner.nextInt();

    int[] arrA = new int[n];
    for (int i = 0; i < n; i++) {
        arrA[i]=scanner.nextInt();
    }
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
        int i1 = scanner.nextInt();
        map.put(i1, i);
    }

    int[][] arr=new int[n][n];

    for (int i = 0; i < n; i++) {

        Integer value1 = map.get(arrA[0]);
        Integer value2 = map.get(arrA[i]);
        if (value2 > value1) {
            arr[0][i]=2;//+1
        }else {
            arr[0][i]=1;
        }
    }
    for (int i = 1; i < n; i++) {
        for (int j = i; j < n; j++) {

                Integer value1 = map.get(arrA[i]);
                Integer value2 = map.get(arrA[j]);
                if (value2 > value1) {
                    arr[i][j]=arr[i-1][j-1]+1;//+1
                }else {
                    arr[i][j]=arr[i-1][j]>arr[i][j-1]?arr[i-1][j]:arr[i][j-1];
                }

        }
    }
    System.out.println(arr[n-1][n-1]);
}

}
