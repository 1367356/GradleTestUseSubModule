package com.li;

import org.junit.Test;

/**
 * 连续子数组的最大和。
 */
public class Question31 {

    public int maxSumSubArray(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int max=0;
        int sum=arr[0];
        for (int i = 1; i < arr.length; i++) {

            if(sum<0){
                sum=arr[i];
            }else {
                sum = sum + arr[i];
            }
            if (max < sum) {
                max=sum;
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = {2, 3, 4, -45, 3, 2, 4, 2};
        int i = maxSumSubArray(arr);
        System.out.println(i);
    }
}
