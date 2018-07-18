package com.li.meiTuan;


import org.junit.Test;

/**
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 */
public class ZuiDaZiLianXuZiFuChuan {
    @Test
    public void test() {

        char[] arr1 = {'a','b','c','d','e'};
        char[] arr2 = {'a','b','g','d','e'};

        int[][] arr = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arr[i][0]=0;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[0][i]=0;
        }
        int maxLength=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j]){
                    if(i==0 || j==0){
                        arr[i][j]=1;
                        continue;
                    }
                    arr[i][j]=arr[i-1][j-1]+1;
                    maxLength=Math.max(maxLength,arr[i][j]);
                }
            }
        }

//        System.out.println(arr[arr1.length-1][arr2.length-1]);
        System.out.println(maxLength);
    }

}
