package com.li.chapter04;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-22 10:20
 **/
public class ZuiDaZiShuZhu {

    public static void main(String[] args){
        int[] arr = {-4, -5, -7, -6, -5, -4, -5, -6};

        int max=arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = sum + arr[i];
            if (max < sum) {
                max=sum;
            } else if (sum < 0) {
                sum=0;
            }
        }

        System.out.println(max);
    }
}
