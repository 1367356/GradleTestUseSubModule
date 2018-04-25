package com.li;

/**
 * 旋转数组的最小数字。
 */
public class Question08 {
    public int min(int[] numbers, int length) throws InterruptedException {
        if (numbers == null || length <= 0) {
            throw new InterruptedException("invalid parameters");
        }
        int index1=0;
        int index2=length-1;
        int indexMid=index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid=index2;
                break;
            }
            indexMid=(index1+index2)/2;

            //如果下标为index1,index2和indexMid指向的三个数字相等，则只能顺序查找。
            if(numbers[index1]==numbers[index2] && numbers[index2]==numbers[indexMid]){
                return minInOrder(numbers, index1, index2);
            }
            if (numbers[indexMid] >= numbers[index1]) {
                index1=indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2=indexMid;
            }
        }
        return numbers[indexMid];
    }

    /**
     * 顺序查找
     * @param numbers 数组
     * @param index1 角标值1
     * @param index2 角标值2
     * @return 最小值
     */
    private int minInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i =index1+1; i < index2 ; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}
