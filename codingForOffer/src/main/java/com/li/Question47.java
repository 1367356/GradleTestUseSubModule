package com.li;

/**
 * 不用加减乘除做加法
 */
public class Question47 {
    public int add(int num1, int num2) {
        int sum,carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
