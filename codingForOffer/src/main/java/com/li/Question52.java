package com.li;

/**
 * 构建乘积数组 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * C[i]=A[0]*A[1]*...*A[i-1]=C[i-1]*A[i-1]
 * D[i]=A[i+1]*...*A[n-1]=D[i+1]*A[i+1];
 * B[i]=C[i]*D[i]
 */
public class Question52 {

    public void multiply(int[] arr1, int[] arr2) {
        int length1=arr1.length;
        int length2=arr2.length;

        if (length1 == length2 && length2 > 1) {
            arr2[0]=1;
            for (int i = 0; i < length1; i++) {
                arr2[i] = arr2[i - 1] * arr1[i - 1];
            }
            double temp=1;
            for (int i = length1-2; i >= 0; i--) {
                temp = arr1[i + 1];
                arr2[i]*=temp;
            }
        }
    }
    
}
