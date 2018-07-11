package com.li.chapter24.mydijstra;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-28 19:45
 *   自己编写迪杰斯特拉算法  ,解决图论及其应用 1.4节  a到b的最短路问题
 **/
public class MyDijStraAlgorithm {

    public static void main(String[] args){
        MyDijStraAlgorithm dijStraAlgorithm=new MyDijStraAlgorithm();
        int[] minDisArr = dijStraAlgorithm.dijstra(0);
        for (int i = 0; i < minDisArr.length; i++) {
            System.out.println(minDisArr[i]);
        }
    }

    public int[] dijstra(int vertx) {

        int[][] arrWeight=getArrOfGraph();
        int[] arrVertx = arrWeight[vertx];   //与vertx相邻的点取出

        boolean[] isFound = new boolean[arrVertx.length];
        isFound[vertx]=true;

//        int[] minDistance = new int[arrVertx.length];  //存储源点到各个节点的最短距离
//        minDistance[vertx]=0;  //vertx到vertx的距离为0

        for (int i = 0; i < arrVertx.length; i++) {  //遍历所有的点
            int mindis=Integer.MAX_VALUE;
            int v=vertx;
            for (int j = 0; j < arrVertx.length; j++) {
                if (!isFound[j]) {
                    if (mindis > arrVertx[j]) {
                        mindis = arrVertx[j];
                        v=j;
                    }
                }
            }

            isFound[v]=true;

            for (int j = 0; j < arrVertx.length; j++) {
                if (!isFound[j]) {
                    if (mindis + arrWeight[v][j] < arrVertx[j]) {  //vertx到v的距离加上v到j的距离
                        arrVertx[j]=mindis + arrWeight[v][j];
                    }
                }
            }
        }
        return arrVertx;

    }


    public int[][] getArrOfGraph() {
        Class clazz = this.getClass();
        InputStream ins = clazz.getResourceAsStream("/data2.txt");
        Scanner scanner = new Scanner(ins);
        int[][] intarr = new int[8][8];
        int row=0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] strarr = line.split(" ");
            for (int i = 0; i < strarr.length; i++) {
                intarr[row][i] = Integer.parseInt(strarr[i]);
            }
            row++;
        }
        return intarr;
    }
}
