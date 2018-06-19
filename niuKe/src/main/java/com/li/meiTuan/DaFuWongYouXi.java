package com.li.meiTuan;


/**
 * 大富翁游戏，美团
 */
public class DaFuWongYouXi {


    public static void main(String[] args){
        test(6);
    }
    public static void test(int n) {
        int[] arr = new int[n+1];
        arr[1]=1;
        for (int i = 1; i <= n; i++) {
            int max=0;
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    max++;
                }else {
                max = max + arr[i-j];
                }
            }
            arr[i]=max;
        }
        System.out.println(arr[n]);
    }
}
