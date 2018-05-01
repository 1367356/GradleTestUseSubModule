package com.li;

import static java.util.Arrays.sort;

/**
 * 扑克牌的顺子
 */
public class Question44 {
    public boolean isContinuous(int[] numbers, int length) {
        if (numbers == null || length < 1) {
            return false;
        }
        sort(numbers);//将numbers排序
        
        int numberOfZero=0;
        int numberOfGap=0;
        //统计数组中0的个数
        for (int i = 0; i < length && numbers[i]==0; i++) {
            ++numberOfZero;
        }

        //统计数组中的间隔数目
        int small=0;
        int big=small+1;
        while (big < length) {
            //两个数相等，有对子，不可能是顺子
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numberOfGap+=numbers[big]-numbers[small]-1;
            small=big;
            big++;
        }
        return numberOfGap>small?false:true;
    }
}
