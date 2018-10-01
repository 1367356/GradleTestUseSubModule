package com.li.aiqiyi;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Main1 niuNiuYuNiuNiu=new Main1();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/aiqiyi/data1");
        Scanner scanner = new Scanner(Systemin);

        String line=scanner.nextLine();
        int length = line.length();
        int[] arr = new int[length];
        int[] minusArr1=new int[length/2];
        int[] minusArr2=new int[length/2];
        for (int i = 0; i < length; i++) {
            int i1 = Integer.parseInt(line.charAt(i) + "");
            arr[i] =i1;
            if (i < 3) {
                minusArr1[i]=9-i1;
            }else {
                minusArr2[i-3]=9-i1;
            }
        }

        int sum1 = arr[0] + arr[1] + arr[2];
        int sum2 = arr[3] + arr[4] + arr[5];

        int minusSum=sum1-sum2;
        int absMinus=Math.abs(sum1-sum2);

        if (absMinus == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(minusArr1);
        Arrays.sort(minusArr2);

        if (minusSum < 0) {
            if (minusArr1[2]>=absMinus){
                System.out.println(1);
            } else if ((minusArr1[2]+minusArr1[1])>=absMinus) {
                System.out.println(2);
            }else {
                System.out.println(3);
            }
        }else {
            if (minusArr2[2]>=absMinus){
                System.out.println(1);
            } else if ((minusArr2[2]+minusArr2[1])>=absMinus) {
                System.out.println(2);
            }else {
                System.out.println(3);
            }
        }

    }
}