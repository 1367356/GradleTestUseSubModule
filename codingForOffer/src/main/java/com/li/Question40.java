package com.li;

/**
 * 面试题40：数组中只出现一次的数字
 */
public class Question40 {

    public void findNumsAppearOnce(int[] data, int length, int num1, int num2) {
        if (data == null || length < 2) {
            return;
        }
        int resultExclusiveOr=0;
        for (int i = 0; i < length; i++) {
            resultExclusiveOr ^= data[i];
        }
        int indexOf1 = findFirstBitIs1(resultExclusiveOr);

        num1=num2=0;
        for (int j = 0; j < length; j++) {
            if (isBit1(data[j], indexOf1)) {
                num1 ^= data[j];
            }else {
                num2 ^= data[j];
            }
        }

    }

    private boolean isBit1(int num, int indexBit) {
        num=num>>indexBit;
//        return num & 1;
        return false;
    }


    private int findFirstBitIs1(int num) {
        int indexBit=0;
        while (((num&1)==0)&&(indexBit<8*num)){
            num=num>>1;
            ++indexBit;
        }
        return indexBit;
    }
}
