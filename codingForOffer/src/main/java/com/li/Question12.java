package com.li;

import org.junit.Test;

/**
 * 打印1到最大的n位数
 */
public class Question12 {


    @Test
    public void test() {
        print1ToMaxNDigits(2);
    }

    public void print1ToMaxNDigits(int n) {
        if (n <= 0) {
            return;
        }
        int[] number = new int[n];

        for (int i = 0; i < 10; i++) {
            number[0] =  i;
            print1ToNDigitsRecursively(number, n, 0);
        }
    }

    private void print1ToNDigitsRecursively(int[] number, int n, int index) {

        if (index == n - 1) {
            int head=0;
            while (number[head] == 0 && head<n-1) {
                head++;
            }
            for (int i = head; i < n; i++) {
                System.out.print(number[i]);
            }
            System.out.println();
            return;
        }
//        if (index == n - 1) {
//            if(number[0]!=0){
//            System.out.print(number[0]);
//            }
//            for (int i = 1; i < n; i++) {
//                System.out.print(number[i]);
//            }
//            System.out.println();
//
//            return;
//        }
        for (int i = 0; i < 10; i++) {
                number[index + 1]=  i;
            print1ToNDigitsRecursively(number,n,index+1);
        }
    }
}
