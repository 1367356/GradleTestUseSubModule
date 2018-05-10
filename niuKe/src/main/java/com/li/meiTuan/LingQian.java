package com.li.meiTuan;

/**
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 */
public class LingQian {
    public static void main(String[] args){

        //N是容量
        int N=40;
        /**
         * 8845

         对应输出应该为:

         95164850220

         你的输出为:

         3360

         */
        //value是面额，足够多
        int[] values = {1,5,10,20,50,100};  //面额
        int[][] sums=new int[values.length][ N + 1];  //sums[i][j]表示当可以放入前i件物品且背包容量为j时的最大价值。
        for (int i = 1; i <= N; i++) {
            sums[0][i]=1; //第values[0]件物品，i容量
        }
        for (int i = 1; i < values.length; i++) {
            sums[i][0]=1;
        }

        for (int i = 1; i< values.length; i++) {  //每次添加一件物品
            int count=0;
            for (int j = 1; j <= N; j++) {
                if(j%(values[i])==0){
                    count++;
                    if (j == values[i]) {  //遇到一种新面额和容量相等
                        sums[i][j] = sums[i-1][j] + 1;  //总量相等，没有新面额+1，
                    }else {
                        sums[i][j] = sums[i-1][j]+count;//sums[i][j - values[i]] + count;  //values[i]=1,代表多了一种方案,2*values[i],3*values[i]}
                    }
                } else {
//                    sums[i][j] = sums[i-1][j];  //总量相等，没有新面额时
//                    sums[i][j] = sums[i][j - 1]>(sums[i-1][j]+count)?sums[i][j - 1]:(sums[i-1][j]+count);  //sums[i-1][j]+count  已经添加新面额了
                    sums[i][j] = sums[i-1][j]+count;
                }
            }
        }
        System.out.println(sums[values.length-1][N]);
    }
}
