package com.li.jinRiTouTiao;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-12 09:48
 * 考试
 **/
public class Question3 {
    public static void main(String[] args){
        Class clazz = Question3.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/jinRiTouTiao/question3.txt");
        Scanner scanner = new Scanner(ins);

        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i]=scanner.nextInt();
        }

        int[][] maxa = new int[n][n];
        maxa[0][0] = a[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j<n; j++) {
                if (j == 0) {
                    continue;
                }
                maxa[i][j]=maxa[i][j-1]>a[j]?maxa[i][j-1]:a[j];
            }
        }

        int[][] maxb = new int[n][n];
//        maxb[0][0] = n[0];
        for (int i = 0; i < n; i++) {
            maxb[i][i]=b[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j<n; j++) {
                if (j == 0) {
                    continue;
                }
                maxb[i][j]=maxb[i][j-1]<b[j]?maxb[i][j-1]:b[j];
            }
        }

        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j<n; j++) {
                if (maxb[i][j] > maxa[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
