package com.li.zhaoshangyinhang;

public class My01BeiBao {
    public static void main(String[] args){
        int[] values={2,2,6,5,4};
        int[] weights={6,3,5,4,6};

        int v=10;  //背包容量
        int[][] sums=new int[values.length][v+1];
        for (int i = 0; i < values.length; i++) {
            sums[i][0] = values[i];
        }

        //sums[i][j]表示当可以放入前i件物品且背包容量为j时的最大价值。

        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < v+1; j++) {
                if(j<weights[i]){
                    sums[i][j]=sums[i-1][j];  //前面代表物品，后面代表容量。说明第i个物品放不进去。
                }else {
                    if(sums[i-1][j-weights[i]]+values[i]<sums[i-1][j]){
                        sums[i][j]=sums[i-1][j];
                    }else {
                        sums[i][j]=sums[i-1][j-weights[i]]+values[i];
                    }
                }
            }
        }
        System.out.println(sums[values.length-1][v]);
    }
}
