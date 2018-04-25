package com.li;

/**
 *
 */
public class Question09 {
    /**
     * 题目1：斐波那契数列，改进之后的算法，可以减少运行时间。使用循环代替递归。
     * @param n
     * @return
     */
    public long Fibonacci(int n) {
        int[] result={0,1};
        if (n < 2) {
            return result[n];
        }
        long fibNMinusOne=1;
        long fibNMinusTwo=0;
        long fibN=0;

        for(int i=2;i<=n;i++) {
            fibN=fibNMinusOne+fibNMinusTwo;
            fibNMinusTwo=fibNMinusOne;
            fibNMinusOne=fibN;
        }
        return fibN;
    }

    /**
     * 题目2：一致青蛙一次可以跳上一级台阶，也可以跳上2级，求该青蛙跳上一个n级的台阶共有多少种跳法。
     */
    public int sum(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sumNum=sum(n-1)+sum(n-2);

        return sumNum;
    }
}
