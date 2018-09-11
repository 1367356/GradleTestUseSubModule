package com.li.huawei;

import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-22 19:37
 **/
public class Main {

    public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            int length=s.length();
            int[][] arr=new int[length][length];

            char[] chars1 = s.toCharArray();
            char[] chars2=chars1;

            int index=0;
            int max=0;

            for (int i = 0; i < chars1.length; i++) {
                if(chars2[0]==chars1[i]){
                    arr[0][i]=1;
                }
            }

            for (int i = 1; i < chars1.length; i++) {
                for (int j = i+1; j < chars2.length; j++) {
                    if(chars1[i]==chars2[j]){
                        arr[i][j]=arr[i-1][j-1]+1;
                        if(max<arr[i][j]){
                            max=arr[i][j];
                            index=j;
                        }
                    }else {
                        arr[i][j]=0;
                    }
                }
            }

            for (int i = 0; i < max; i++) {
                System.out.print(chars1[index-max+1+i]);
            }

             System.out.println(" "+max);
        }
}
