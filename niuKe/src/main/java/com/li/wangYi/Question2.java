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

        InputStream ins = clazz.getResourceAsStream("/wangYi/question2.txt");
        Scanner scanner = new Scanner(ins);

        String line1 = scanner.nextLine();
        int n=Integer.parseInt(line1);

        String internet = scanner.nextLine();
        String[] stringNums = internet.split(" ");
        int[] interNums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            interNums[i] = Integer.parseInt(stringNums[i]);
        }

        int[] sumarr = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum = sum + interNums[i];
            sumarr[i]=sum;
        }

        String ks=scanner.nextLine();
        int k = Integer.parseInt(ks);
        
        String line3 = scanner.nextLine();
        String[] stringNum3 = line3.split(" ");
        int[] intNums3 = new int[k];
        for (int i = 0; i <k; i++) {
            intNums3[i] = Integer.parseInt(stringNum3[i]);
        }

        for (int i = 0; i < k; i++) {
            int temp = intNums3[i];


            //二分查找
            int j=binarySearch(temp, sumarr,0,sumarr.length-1);
//            while (temp>sumarr[j]){
//                j++;
//            }
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
