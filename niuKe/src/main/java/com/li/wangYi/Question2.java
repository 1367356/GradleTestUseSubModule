package com.li.wangYi;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-10 18:53
 *   网易考试：笔试
 **/
public class Question2 {
    public static void main(String[] args){

        Class clazz = Question2.class.getClass();

        InputStream ins = clazz.getResourceAsStream("/month9day16/wangYi/question2.txt");
        Scanner scanner = new Scanner(ins);

        int n=scanner.nextInt();
        int[] duiNums = new int[n];   //堆数
        for (int i = 0; i < n; i++) {
            duiNums[i]=scanner.nextInt();
        }
        int askNum = scanner.nextInt();  //询问次数

        int[] sumarr = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum = sum + duiNums[i];
            sumarr[i]=sum;
        }

        for (int i = 0; i < askNum; i++) {
            int temp = scanner.nextInt();
            //二分查找
            int j=binarySearch(temp, sumarr,0,sumarr.length-1);
            System.out.println(j+1);
        }

    }

    private static int binarySearch(int temp, int[] sumarr,int low,int high) {
        if (low >= high) {
            return high;
        }
        int middle=(low+high)/2;
        int value = sumarr[middle];
        if (value > temp) {
            return binarySearch(temp,sumarr,low, middle);
        }else if(value<temp){
                return binarySearch(temp, sumarr, middle + 1, high);
        }else {
            return middle;
        }
    }
}
