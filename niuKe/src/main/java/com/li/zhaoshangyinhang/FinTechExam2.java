package com.li.zhaoshangyinhang;

/**
 * 求一个数组中不相邻元素的最大和。
 */
public class FinTechExam2 {
    public static void main(String[] args){

        //先选出一个最大值，在所有的房子中。根据他来进行动态规划。
//        int n=100;  //住的户数
//        int[][] ns=new int[n][];

        int[] a=new int[10];//A
        int size=a.length;
        if (size == 0) {
            System.out.println("0");
        }
        if (size == 1) {
            System.out.println(a[0]);
        }
        if (size == 2) {
            int sum = a[0] > a[1] ? a[0] : a[1];
            System.out.println(sum);
        }
        int noCurrentMax=a[0];
        int currentMax= a[0] > a[1] ? a[0] : a[1];
        for (int i = 2; i < a.length; i++) {
            int temp = noCurrentMax + a[i];
            int temp2=noCurrentMax>currentMax?noCurrentMax:currentMax;

            noCurrentMax=currentMax;
            currentMax=temp2;
        }
        System.out.println("max(noCurrentMax,currentMax)");

    }
}
