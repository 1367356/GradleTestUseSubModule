package com.li;


/**
 * 调整数组顺序使奇数位位于偶数前面。
 */
public class Question14 {
    //调整数组顺序使奇数位位于偶数前面。
    public int[] sortArray(int[] arr) {
        int p1=0;  //指向偶数
        int p2=1;  //去发现奇数，发现与p1交换
        /**
         * 第一个数字为偶数。将第一个数字调整为奇数。
         */
        while (arr[p1]%2!=0){
            p1++;
            p2++;
//            while (arr[p2] % 2 == 0 && p2<arr.length) {
//                p1++;
//                p2++;
//            }
        }
        for (int i = p2; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                int temp=arr[i];
                arr[i]=arr[p1];
                arr[p1]=temp;
                p1++;
            }
        }
        return arr;
    }

    public void test() {
        int[] arr = {3, 43, 2, 3, 34, 23, 23, 432, 334};
        int[] sortArray=sortArray(arr);
        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }

    }
}
