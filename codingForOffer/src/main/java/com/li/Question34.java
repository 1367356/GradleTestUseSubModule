package com.li;

import org.junit.Test;

/**
 * 找到第1500个丑数
 */
public class Question34 {

    /**
     * 不对
     * @param k
     * @return
     */
    public int findUglyNumber(int k) {
        int[] arr = new int[k];

        arr[1]=2;
        int max = arr[1];
        int j=1;
        for (int i = 2; i < k; i++) {
         //   arr[j]*2,arr[j]*3,arr[j]*5.   //当乘5小于已知丑数最大值时，j++;
            while (j <i) {
                if (arr[j] * 2 > max) {
                    max = arr[j]*2;
                    break;
                } else if (arr[j] * 3 > max) {
                    max=arr[j]*3;
                    break;
                } else if (arr[j] * 5 > max) {
                    max=arr[j]*5;
                    break;
                }else {
                    j++;
                }
            }
            arr[i]=max;
        }
        return arr[k-1];
    }

    public int getUglyNumber(int k) {
        if (k <= 0) {
            return 0;
        }
        int[] unlyArr = new int[k];
        int maxUglyNumber=0;
        unlyArr[0]=1;

        int uglyIndex2=0;  //善于利用角标值，也就是指针。
        int uglyIndex3=0;
        int uglyIndex5=0;

        for (int i = 1; i < k; i++) {
            maxUglyNumber = min(unlyArr[uglyIndex2] * 2, unlyArr[uglyIndex3] * 3, unlyArr[uglyIndex5] * 5);
            unlyArr[i]=maxUglyNumber;
            while (unlyArr[uglyIndex2] * 2 <= maxUglyNumber) {
                uglyIndex2++;
            }
            while (unlyArr[uglyIndex3] * 3 <= maxUglyNumber) {
                uglyIndex3++;
            }
            while (unlyArr[uglyIndex5] * 5 <= maxUglyNumber) {
                uglyIndex5++;
            }

        }
        return unlyArr[k - 1];
    }

    public int min(int a,int b,int c) {
        int min=a>b?b:a;
        min=min>c?c:min;
        return min;
    }
    @Test
    public void test() {
        int uglyNumber = findUglyNumber(10);
        int getUglyNumber = getUglyNumber(10);
        System.out.println(getUglyNumber);
    }
}
