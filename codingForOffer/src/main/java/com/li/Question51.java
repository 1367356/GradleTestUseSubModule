package com.li;

/**
 * 数组中重复的数字
 */
public class Question51 {

    public boolean duplicate(int[] numbers,int length,int duplication){
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                    if(numbers[i]==numbers[numbers[i]]){  //存在重复的数字。
                        duplication = numbers[i];
                        return true;
                    }
                    //交换numbers[i] 和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];    //将数组中的值放到对应的角标处。
                numbers[numbers[i]]=temp;
            }
        }
        return false;
    }
}
