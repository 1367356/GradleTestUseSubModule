package com.li;

import org.junit.Test;

import java.util.*;

/**
 * 和为s的两个数字VS和为s连续正数序列
 */
public class Question41 {

    /**
     * 在递增数组中找到两个和为s的两个数字。
     * @param data
     * @param length
     * @param sum
     * @return
     */
    public boolean findNumberWithSum(int[] data, int length, int sum) {
        boolean found=false;
        if (length < 1) {
                return false;
        }

        int index1=0;
        int index2=length-1;

        int num1 = data[index1];
        int num2 = data[index2];

        while (index1<index2){
            if (data[index1] + data[index2] < sum) {
                index1++;
            }else if(data[index1] + data[index2] > sum){
                index2--;
            }else {
                return true;
            }
        }

        return false;
    }

    /**
     * 题目2：输入一个正数s,打印出所有和为s的连续正数序列。
     * 解法：初始化1,2，如果小于，增加大值，如果大于，去掉小值
     */
    public void findContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int small=1;
        int big=2;

        int middle=(1+sum)/2;
        int curSum=small+big;

        while (small < middle) {
            if (curSum == sum) {
                System.out.println(small+big);
            }
            while (curSum > sum && small < middle) {
                curSum-=small;
                small++;
                if (curSum == sum) {
                    System.out.println(small+big);
                }
            }
            big++;
            curSum+=big;
        }
    }

    public void printContinuousSequence(int small, int big) {
        for (int i = small; i < big; i++) {
            System.out.println(i);
        }
    }

    /**
     * 求数组三个数的和等于给定的一个数
     */
    public void threeNum(int[] arr, int k) {

        Map<HashKey,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int sum=k-temp;
            int start=0;
            int end=arr.length-1;

            while (start < end) {
                if (start != i && end != i) {
                    if (arr[start] + arr[end]>sum) {
                        end--;
                    }else if(arr[start] + arr[end]<sum) {
                        start++;
                    }else {
                        System.out.println("start"+arr[start]);
                        System.out.println("i"+arr[i]);
                        System.out.println("end"+arr[end]);
                        Set<Integer> set = new TreeSet();
                        set.add(i);
                        set.add(start);
                        set.add(end);
                        Iterator<Integer> iterator = set.iterator();
                        HashKey hashKey = new HashKey(iterator.next(),iterator.next(),iterator.next());

                        map.putIfAbsent(hashKey, 1);

                        break;
                    }
                }else {
                    if (start == i) {
                        start++;
                    }else {
                        end--;
                    }
                }
            }

        }
        System.out.println(map.size());
    }

    @Test
    public void testThreeNum() {
        int[] arr={1,2,4,7,8,9,14,16};
        int k=20;
        threeNum(arr,k);
    }

}


class HashKey{
    int start;
    int end;
    int i;

    public HashKey(int start, int end, int i) {
        this.start = start;
        this.end = end;
        this.i = i;
    }

    @Override
    public int hashCode() {
        return start+end+i;
    }

    @Override
    public boolean equals(Object o) {
        return start==((HashKey)o).start && end==((HashKey)o).end&&i==((HashKey)o).i;
    }
}
