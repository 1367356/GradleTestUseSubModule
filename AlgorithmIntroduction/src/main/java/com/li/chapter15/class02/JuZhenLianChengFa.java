package com.li.chapter15.class02;

/**
 * 矩阵链乘法:使用动态规划方法
 */
public class JuZhenLianChengFa {

    public static void main(String[] args){
        int[] p={30,35,15,5,10,20,25};  //p.length-1个矩阵
        matrixChainOrder(p);
    }

    public static void matrixChainOrder(int[] p) {  //p个矩阵，要用p.length+1个数字来表示。例如两个矩阵相乘要用p0*p1*p2表示，p1是p0的列，p2的行
        int[][] m = new int[p.length-1][p.length-1];   //保存
//        int[][] s = new int[p.length - 1][p.length-1];

        for (int i = 0; i < m.length; i++) {
            m[i][i]=0;  //矩阵链长度为0时，乘积为0,m[j][j+0];
        }

        //p.length=3;
        for (int i = 1; i < p.length - 1; i++) {  // i 矩阵链的长度
            for (int j = 0; j < p.length-i-1; j++) {  //j从0到p.lenght-i-1   计算长度为i的矩阵链，所有的最优值。
                m[j][j+i]=Integer.MAX_VALUE;   //最大值。
                for (int k = j; k < j+i; k++) {   //求j到j+i这段长度乘积的最小值，  k是分割点
                    int value = m[j][k] + m[k + 1][j + i] + p[j]*p[k+1] * p[j+i+1];  //k为分割点时，乘积的大小
                    if (value < m[j][j + i]) {
                        m[j][j+i]=value;
//                        s[j][j + i]=k;  //j到j+i这段矩阵链最优分割点为 k
                    }
                }
            }
        }


        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[1].length; j++) {
                System.out.print(m[i][j]+"             ");
            }
            System.out.println("");
        }
        System.out.println(m[1][4]);
    }
}
