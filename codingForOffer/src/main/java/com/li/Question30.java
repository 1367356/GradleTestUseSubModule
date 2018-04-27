package com.li;

import org.junit.Test;

/**
 * 最小的k个数。输入n个整数，找出最小的k个数。
 */
public class Question30 {

    /**
     * 方法1:使用快速排序中的partition方法，进行分割，这种方法要修改数组。
     */
    public void leastKNum(int[] numbers,int n,int k) {

        int start=0;
        int end=n-1;

        int index = partition(numbers, n, start, end);

        while (index != k - 1) {
            if (index > k - 1) {
                end=index-1;
                index = partition(numbers, n, start, end);
            }else {
                start=index+1;
                index = partition(numbers, n, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(numbers[i]);
        }

        return ;
    }

    private int partition(int[] numbers, int n, int start, int end) {
        int value = numbers[end];
        int j=start;
        for (int i = start; i <end; i++) {
            if (numbers[i] <= value) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j]=temp;
                j++;
            }
        }
        int temp=value;
        numbers[end]=numbers[j];
        numbers[j]=value;
        return j;

    }

    /**
     * 方法2：
     */

    @Test
    public void test() {
        int[] arr={3, 2, 4, 5, 2, 1, 7};
        leastKNum(arr,arr.length,3);
    }
}
