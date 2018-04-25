package com.li.zhaoshangyinhang;

/**
 * 零钱兑换。
 * 输入
 * 1
 * 3 5
 * 1 2 5
 *
 */
public class FinTechExam {
    public static void main(String[] args){
        //int[] v=new int[3];  //钱的面值
        int[] v = {1,2,5};
        int n=3;//零钱的数
        int k=5;  //整钱

        long[][] mon = new long[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            mon[i][0]=1;   //相当于值value，都是1
        }
        for (int i = 0; i < k+1; i++) {
            mon[0][i]=0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                int index = j - v[i - 1];
                long temp;
                if (index < 0) {
                    temp=0;
                }else {
                    temp = mon[i][index];
                }
                mon[i][j]=temp+mon[i-1][j];  //最优子结构。
            }
        }
        System.out.println(mon[n][k]%100000007);
    }
}
