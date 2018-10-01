package com.li.sina;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int sum=0;
        for (int i = start; i <= end; i++) {
            int count = getCount(i);
            sum=sum+count;
        }

        System.out.println(sum);
    }

   public static int getCount(int num) {
        int count=0;
       while (num>0) {
           count+=num&0x01;
           num>>=1;
       }
       return count;
    }
}