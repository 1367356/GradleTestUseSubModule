package com.li;

/**
 * 二进制中1的个数。
 */
public class Question10 {
    public int numberOf1(int n) {
        int count=0;
        while (n>0) {
            ++count;
            n=(n-1)&n;  //能进行多少次就有多少个1
        }
        return count;
    }
}
