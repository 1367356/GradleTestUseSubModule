package com.li;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字。
 */
public class Question29 {

    /**
     * 解法1：基于partition的O(n)算法。
     */
    public int moreThanHalfNum(int[] numbers) {
        return 0;
    }

    /**
     * 解法2：因为有数字超过数组的一半，用一个map保存数字和次数，当新加入的数字和保存的数字一样时，次数加1，不一样时，次数减1.
     * 当次数为0时，将新数字加入。最终的数字就是求得的数字
     */

    public int moreThanHalfNumber(int[] numbers) {

        int result = numbers[0];
        int times=1;
        for (int i = 1; i < numbers.length; i++) {
            if (times == 0) {
                result = numbers[i];
                times=1;
            }else if(numbers[i]==result){
                times++;
            }else {
                times--;
            }
        }
        return result;
    }

    public boolean checkInvalidArray(int[] numbers) {
        boolean inputInvalid=false;
        if (numbers == null) {
            inputInvalid=true;
        }
        return inputInvalid;
    }

//    public int moreThanHalfNum1(int[] numbers) {
//        int number=0;
//        Map<Integer,Integer> map = new HashMap();
//        for (int i = 0; i < numbers.length; i++) {
//            if (map==null) {
//                map.put(numbers[i], 1);
//            }else {
//                if(0 == map.values().iterator().next()){
//                    map.put(numbers[i], 1);
//                }else {
//
//
//                }
//            }
//        }
//        return number;
//    }
}
