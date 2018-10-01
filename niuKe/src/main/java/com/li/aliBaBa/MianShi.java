package com.li.aliBaBa;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-17 18:03
 **/
public class MianShi {
    public static void main(String[] args){
        MianShi mianShi=new MianShi();
        Class clazz = mianShi.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/zhongxing/data4.txt");
        Scanner scanner = new Scanner(ins);

        int n = scanner.nextInt();  //n
        String[] locations = new String[0];
        calculate(locations);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(String[] locations) {

        //取出数据
        int[][] arr = new int[locations.length+1][2];
        arr[0][0]=0;
        arr[0][1]=0;
        for (int i = 1; i < locations.length+1; i++) {
            String[] splits = locations[i].split(",");
            arr[i][0]=Integer.parseInt(splits[0]);
            arr[i][1]=Integer.parseInt(splits[1]);
        }

        //首先由给定的num个点，组成图的二维数组表示形式
        int[][] matrix = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);  //  图的矩阵表示形式
            }
        }
        //求图的一个最优欧拉环游,起点为0，0

    return 0;
    }

}
