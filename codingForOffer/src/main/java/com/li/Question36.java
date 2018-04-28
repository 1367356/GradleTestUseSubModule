package com.li;

/**
 * 数组中的逆序对
 */
public class Question36 {
    public int inversePairs(int[] data, int length) {
        if (data == null || length < 0) {
            return 0;
        }
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i]=data[i];
        }
        int count = inversePairsCore(data, copy, 0, length - 1);
        return count;
    }

    private int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
        }
        int length=(end-start)/2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        //i初始化为前半段最后一个数字的下标
        int i=start+length;
        //j初始化为后半段最后一个数字的下标
        int j=end;
        int indexCopy=end;
        int count=0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count+=j-start-length;
            }else {
                copy[indexCopy--] = data[j--];
            }
        }
        for(;i>=start;--i) {
            copy[indexCopy--] = data[i];
        }
        for(;j>=start+length+1;--j) {
            copy[indexCopy--] = data[j];
        }
        return left+right+count;
    }
}
