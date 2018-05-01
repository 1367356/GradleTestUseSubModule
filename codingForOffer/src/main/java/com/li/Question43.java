package com.li;

/**
 * n个骰子的点数。
 */
public class Question43 {
    int maxValue=6;

    /**
     * 基于递归的实现
     * number:骰子的个数
     */
    public void printProbability(int number) {
        if (number < 1) {
            return;
        }
        int maxSum=number*maxValue;
        int[] probabilities = new int[maxSum - number + 1];

        for (int i = number; i <maxSum ; i++) {
            probabilities[i - number]=0;
        }
        probability(number, probabilities);

        long total = (long) Math.pow(maxValue, number);//指数函数

        for (int i = number; i < maxSum; i++) {
            double radio=probabilities[i-number]/total;
            System.out.println(radio);
        }
    }

    private void probability(int number, int[] probabilities) {
        for (int i = 1; i <= maxValue; i++) {
            probability(number, number, i, probabilities);
        }
    }

    private void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum-original]++;
        }else {
            for (int i = 1; i <= maxValue; i++) {
                probability(original,current-1,sum+i,probabilities);
            }
        }
    }

    /**
     * 使用循环求骰子点数
     * 定义一个二维数组，下一个是上一个n-1,n-2..n-6的和
     */
    public void printProbabilityUseCycle(int number) {
        if (number < 1) {
            return;
        }
            int[][] probabilities = new int[2][];
            probabilities[0] = new int[maxValue * number + 1];
            probabilities[1] = new int[maxValue * number + 1];

            int flag=0;//作为标志
            for (int i = 1; i < maxValue; i++) {  //设置起始值,第一个骰子
                probabilities[flag][i]=1;
            }
            for(int k=2;k<=number;k++) {
                for (int i = 0; i < k; i++) {
                    probabilities[1-flag][i]=0;  //k之前的清零
                }
                for (int i = k; i < maxValue*k; i++) {
                    probabilities[1-flag][i]=0;
                    for(int j=1;j<=i&&j<=maxValue;j++) {
                        probabilities[1 - flag][i] += probabilities[flag][i - j];
                    }
                }
                flag=1-flag;
            }

        long total = (long) Math.pow(maxValue, number);//指数函数
        for (int i = number; i < maxValue*number; i++) {
            double radio=probabilities[flag][i]/total;
            System.out.println(radio);
        }
    }
}