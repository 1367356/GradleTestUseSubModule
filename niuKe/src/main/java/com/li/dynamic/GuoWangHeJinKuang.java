package com.li.dynamic;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-16 18:14
 * <p>
 * https://www.sohu.com/a/153858619_466939
 * <p>
 * 题目二： 国王和金矿
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
 * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，
 * 要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 **/
public class GuoWangHeJinKuang {

    public static void main(String[] args){
        int[][] arr = {{200, 300, 350, 400, 500},{3,4,3,5,5}};

        //解法：一个人能挖多少，2个人能挖多少，三个人能挖多少,....
        //4个人挖的等于3个人挖的加一个人挖的，等于两个两个人挖的
        int[] num = new int[11];   //10等于arr[9]+1,arr[8]+2,...  ；如果有金砖是10的，arr[10]; 比较
        int[][] nums = new int[10][5];

        /**
         * 逐个添人
         */
        for (int i = 0; i < 10; i++) {  //10个人
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < 5; j++) {  //矿
                if (i > arr[1][j]) {

                    for (int k = 0; k < i/2; k++) {
                        if (num[i - k] + num[k] > max) {
                            num[i] = num[i-k]+num[k];  //最大值
                            max=num[i-k]+num[k];
                        }else {
                            num[i] = num[i - 1];
                        }
                    }
                }else {
                    nums[i][j]=0;
                }
            }
        }
    }
}
