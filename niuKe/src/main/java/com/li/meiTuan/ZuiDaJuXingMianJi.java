package com.li.meiTuan;

import java.util.Scanner;

/**
 * 最大矩形面积
 * 输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000)
 第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000)
 输出描述:
 输出一个整数,表示最大的矩阵面积。

 输入例子1:
 6
 2 1 5 6 2 3

 输出例子1:
 10
 */
public class ZuiDaJuXingMianJi {
    /**
     * 解法1：利用动态规划
     */
    public void test() {

        int[] arr={3,2,4,5,7,2};
        int maxValue=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = i; j >=0; j--) {
                min = Math.min(min, arr[j]);
                maxValue = Math.max(maxValue, min * (i - j + 1));
            }
        }
        System.out.println(maxValue);

    }

    /**
     * 解法2
     */
    public void test2() {
        int[] arr={3,2,4,5,7,2};
        int maxValue=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int length=1;
            int left=i-1;
            int right=i+1;
            while (left>=0 && arr[left]>=arr[i]){
                left--;
                length++;
            }
            while (right<arr.length && arr[right]>=arr[i]){
                right++;
                length++;
            }
            int value=length*arr[i];
            maxValue = Math.max(value, maxValue);
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int[] arr = new int[N];  //面额

        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }

        int maxValue=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int length=1;
            int left=i-1;
            int right=i+1;
            while (left>=0 && arr[left]>=arr[i]){
                left--;
                length++;
            }
            while (right<arr.length && arr[right]>=arr[i]){
                right++;
                length++;
            }
            int value=length*arr[i];
            maxValue = Math.max(value, maxValue);
        }
        System.out.println(maxValue);


    }
}
