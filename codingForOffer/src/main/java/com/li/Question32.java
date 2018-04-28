package com.li;

/**
 * 从1到n整数中1出现的次数。
 */
public class Question32 {
    boolean invalidInput = false;

    //时间复杂度为O（logn）
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            invalidInput = true;
            return 0;
        }

        StringBuilder s = new StringBuilder(((Integer)n).toString());


        return NumberOf1(s);

    }

    int NumberOf1(StringBuilder s){
        if(s == null || s.length() == 0 || s.charAt(0) < '0' || s.charAt(s.length()- 1) > '9'){
            return 0;
        }

        int first = s.charAt(0) - '0';

        int length = s.length();

        if(length == 1 && first == 0){
            return 0;
        }

        if(length == 1 && first > 0){
            return 1;
        }

        //假设n = 21345
        //numFirstDigit是数字10000 - 19999 的第一个位中的数目
        int numFirstDigit = 0;
        if(first > 1){
            numFirstDigit = PowerBase10(length - 1);

        }else if(first == 1){
            numFirstDigit = Integer.parseInt(s.substring(1)) + 1;

        }
        //numOtherDigits是1346 - 21345除了第一位之外的数位中的数目
        int numOtherDigits = first * (length - 1) * PowerBase10(length - 2);
        //numRecursive是1 - 1345中的数目
        int numRecursive = NumberOf1(s.deleteCharAt(0));

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    int PowerBase10(int n){
        int result = 1;
        for(int i = 0; i < n; i++){
            result *= 10;

        }

        return result;
    }
}
