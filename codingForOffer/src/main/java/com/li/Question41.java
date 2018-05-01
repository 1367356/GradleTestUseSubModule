package com.li;

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

}
