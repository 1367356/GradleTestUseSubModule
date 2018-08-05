package com.li.dynamic;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-01 17:08
 * 剪绳子： https://blog.csdn.net/tongxinzhazha/article/details/77407648
 *
 * https://www.cnblogs.com/wuyuegb2312/p/3281264.html
 **/
public class JianShengZi {

    public static void main(String[] args){
        int N=8;    //绳长
        int M=3;   //段数

        //动态规划
        int[] arr = new int[N+1];
        arr[1]=1;
        arr[0]=1;

        int[][] arrs = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            int max=Integer.MIN_VALUE;
            int innerIndex=0;
            for (int j = i; j >0 ; j--) {
                int x = arr[i - j] * j;
                if (max < x) {
                    max=x;
                    innerIndex=j;
                }
            }
            arr[i]=max;
            arrs[i][innerIndex]=max;

        }
        System.out.println(arr[8]);

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[0].length; j++) {
                System.out.print(arrs[i][j]);
            }
            System.out.println("");
        }
    }
}
