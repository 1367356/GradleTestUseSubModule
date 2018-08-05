package com.li.shenxinfu;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-21 18:51
 *
 *  判断一个数组，翻转一定次数，能否成为排好序的次数。
 *
 *  思路：求数组的逆序对的大小和翻转次数的大小比较
 **/
public class Main5 {
    public static void main(String[] args){

        int[] data={3,1,2,5,2};
        int[] copy = new int[data.length];
        int start=0;
        int end=data.length;

        for (int i = 0; i < end; i++) {
            copy[i] = data[i];
        }
        int count = count(data, copy, start, end-1);
        System.out.println(count);


    }

    public static int count(int[] data,int[] copy,int start,int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length=(end-start)/2;
        int left = count(data, copy, start, start + length);
        int right = count(data, copy, start + length + 1, end);

        int count=0;

        int leftend=start+length;
        int rightend=end;
        int copyIndex=end;

        while (leftend>start&&rightend>start+length+1) {
            if (data[leftend] > data[rightend]) {
                copy[copyIndex--] = data[leftend--];
                count += rightend - (start + length);
            }else {
                copy[copyIndex--] = data[rightend--];
            }
        }

        for (;leftend>start;leftend--) {
            copy[copyIndex--] = data[leftend--];
        }

        for (;rightend>start+length+1;rightend--) {
            copy[copyIndex--] = data[rightend];
        }

        return left+right+count;
    }
}
