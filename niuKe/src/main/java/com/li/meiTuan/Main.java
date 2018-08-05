package com.li.meiTuan;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String line1=scanner.nextLine();
        char[] arr1=line1.toCharArray();

        String line2=scanner.nextLine();
        char[] arr2=line1.toCharArray();

        int[][] arr = new int[arr1.length][arr2.length];
        int maxLength=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j]){
                    if(i==0 || j==0){
                        arr[i][j]=1;
                        maxLength=arr[i][j];
                        continue;
                    }
                    arr[i][j]=arr[i-1][j-1]+1;
                    maxLength=Math.max(maxLength,arr[i][j]);
                }
            }
        }
        System.out.println(maxLength);
    }
}