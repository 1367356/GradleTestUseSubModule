package com.li.chapter06;

import java.util.Scanner;

/**
 * 从控制台输入两个数字，并打印
 */
public class Question04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[2];
        int j=0;
        while (scanner.hasNext() && j<2) {
            int i = scanner.nextInt();
            arr[j++]=i;
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
