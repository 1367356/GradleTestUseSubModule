package com.li.chapter15;

/**
 * 最长公共子序列
 */
public class ZuiChangGongGongZiXuLie {

    static char[] arr1 = {'a', 'b', 'd', 'b','e','a'};   //序列1
    static char[] arr2 = {'b', 'e', 'd', 'a', 'a'};  //序列2

    public static void LCSLength() {

        int[][] sameNum = new int[arr1.length][arr2.length];

        /**
         * 判断arr1第1个元素和arr2所有元素是否相等，相等赋值1
         */
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[0] == arr1[i]) {
                sameNum[i][0]=1;
                continue;
            }
            sameNum[i][0]=0;
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr1[0] == arr2[i]) {
                sameNum[0][i]=1;
                continue;
            }
            sameNum[0][i]=0;
        }

        /**
         * 动态规划，从小到大计算，且有空间保留小的计算的结果。
         */
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    sameNum[i][j]=sameNum[i-1][j-1]+1;
                } else if (sameNum[i - 1][j] > sameNum[i][j - 1]) {
                    sameNum[i][j]=sameNum[i-1][j];
                }else {
                    sameNum[i][j]=sameNum[i][j-1];
                }
            }
        }

        for (int i = 0; i < sameNum.length; i++) {
            for (int j = 0; j < sameNum[0].length; j++) {
                System.out.print(sameNum[i][j]+"      ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        LCSLength();
    }
}
