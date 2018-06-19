package com.li.chapter15.Prictice;

/**
 * 练习题1： 求有向无环图两点的最大值。
 *
 * 思路： 给定有向无环图的矩阵， 从1-n的最长距离，2-n的最长距离...
 *
 * maxLength[i,j]=maxlenth[i,j-1]+length[j]  //length[j]是与终点相连的很多点之一。最大的一个。
 */
public class Question01 {

    public static void main(String[] args){
        int[][] matrix = {{0,2,3},{0,0,2},{0,0,0}};
        maxLength1(matrix);
    }
    /**
     *方法1
     * @param matrix 有向无换图的矩阵表示
     */
    public static void maxLength1(int[][] matrix) {
        int[][] maxLength=new int[matrix.length][matrix[0].length];  //存储i到j的最长距离
        for (int i = 0; i < matrix.length; i++) {
            maxLength[i][0] = 0;  //每个节点到初始节点都为0
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    maxLength[j][i]=0;  //因为无环
                    continue;
                }
                //j到i;
                int length = matrix[i].length;//遍历，第i个节点相邻的节点
                maxLength[j][i]=Integer.MIN_VALUE;
                for (int k = 0; k < i; k++) {
                    int value=maxLength[j][k]+matrix[k][i];
                    if (value > maxLength[j][i]) {
                        maxLength[j][i]=value;
                    }
                }
            }

        }
        for (int i = 0; i < maxLength.length; i++) {
            for (int j = 0; j < maxLength[0].length; j++) {
                System.out.print(maxLength[i][j]+"        ");
            }
            System.out.println("");
        }
    }

//    /**
//     *方法2
//     * @param matrix 有向无换图的矩阵表示
//     */
//    public static void maxLength2(int[][] matrix) {
//
//        int[][] maxLength = new int[matrix.length][matrix[0].length];  //存储i到j的最长距离
//        for (int i = 0; i < matrix.length; i++) {
//            maxLength[i][0] = 0;  //每个节点到初始节点都为0
//        }
//
//        for (int l = 0; l < maxLength.length-1; l++) {  //长度，s-t
//            for (int i = 0; i < maxLength.length; i++) {
//                int j=i+l-1;
//                int value=Integer.MIN_VALUE;
//                for (int k = i; k < j; k++) {
//
//                }
//            }
//        }
//    }
}
