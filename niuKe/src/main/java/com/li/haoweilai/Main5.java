package com.li.haoweilai;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main5 {
    public static void main(String[] args){
        Main5 main1=new Main5();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/haoweilai/main5");
        Scanner scanner = new Scanner(Systemin);

        int N=100;
        int[][] douarrs=new int[N][N];
        int[] arri = new int[100];
        int index=0;
        while (scanner.hasNextInt()) {
            arri[index++]=scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            douarrs[i][i]=arri[i];
        }

        for (int i = 0; i < N; i++) {
            if (arri[i] > arri[0]) {
                douarrs[0][i] = arri[0] + arri[i];
            }else {
                douarrs[0][i]=arri[i];
            }
        }

        int max=0;
        for (int i = 1; i < N; i++) {
            for (int j = i; j < N; j++) {
                if ( j==i) {
                    douarrs[i][j]=douarrs[i-1][j];
                    if (douarrs[i][j] > max) {
                        max = douarrs[i][j];
                    }
                }else if(arri[j]>arri[i] && douarrs[i][i]+arri[j] > douarrs[i-1][j]){
                    douarrs[i][j]=douarrs[i][i]+arri[j];
                    if (douarrs[i][j] > max) {
                        max = douarrs[i][j];
                    }
                }else {
                    douarrs[i][j]=douarrs[i-1][j];
                    if (douarrs[i][j] > max) {
                        max = douarrs[i][j];
                    }
                }
            }
        }

        System.out.print(max);
    }
}
