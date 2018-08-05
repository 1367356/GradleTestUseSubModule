package com.li.dynamic;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-01 19:26
 * 我们有面值为1元3元5元的硬币若干枚，如何用最少的硬币凑够11元？
 * 硬币问题
 **/
public class YingBiWenTi {
    public static void main(String[] args){
        selectSumMoneyAsVariable();
    }

    public static void selectSumMoneyAsVariable() {

        int[] coins = {1, 3, 5};
        int num=12;

        int[] number = new int[num];
        for (int i = 0; i < coins.length; i++) {
            number[coins[i]] = 1;
        }

        for (int i = 2; i < num; i++) {
                int min=Integer.MAX_VALUE;
            for (int k = 1; k <=i/2 ; k++) {
                int value = number[i - k]+number[k];
                min=min>value?value:min;
            }
            if (number[i] !=1) {
                number[i]=min;
            }
        }

        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }

    public static void selectCoinAsVariable() {

        int[] coins = {1, 3, 5};

        int num=12;
        int[][] nums = new int[coins.length][num];

        for (int i = 0; i < num; i++) {
            nums[0][i]=i;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < num; j++) {
                if (j >= coins[i]) {
                    nums[i][j]=nums[i][j-coins[i]]+1>nums[i-1][j]?nums[i-1][j]:nums[i][j-coins[i]]+1;
                }else {
                    nums[i][j] = nums[i - 1][j];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j]+"   ");
            }
            System.out.println("");
        }

        System.out.println(nums[coins.length-1][num-1]);
    }
}
