package com.li;

/**
 * 圆圈中最后剩下的数字
 */
public class Question45 {

    public int lastRemaining(int n,int m) {
        if(n<1||m<1)
            return -1;
        int last=0;
        for (int i = 2; i < n; i++) {
            last=(last+m)%i;
        }
        return last;
    }
}
