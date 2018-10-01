package com.li.shangtang;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/kedaxunfei/data1.txt");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();

        int k=scanner.nextInt();


        int[] arr = new int[n];
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            int i1=scanner.nextInt();
            arr[i]=i1;
            arr1[i]=i1;
        }

        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length-1];

        double d=(min+max)/2;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < d) {
                arr1[i]=arr1[i]+k;
            }else{
                arr1[i]=arr1[i]-k;
            }
        }
        Arrays.sort(arr1);
        System.out.println(arr1[n-1]-arr1[0]);

    }
}