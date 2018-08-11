package com.li.wangYi;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-10 18:53
 **/
public class Question1 {
    public static void main(String[] args){

        Class clazz = Question1.class.getClass();
        /**
         * txt文件中，例如  1 2 4 8 8    1是起始节点，2 相邻节点，4是1,2之间的权重，8是相邻节点，8是1,8之间的权重。
         */
        InputStream ins = clazz.getResourceAsStream("/wangYi/question1.txt");
        Scanner scanner = new Scanner(ins);

        String line1 = scanner.nextLine();
        String[] split = line1.split(" ");
        int n=Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        String internet = scanner.nextLine();
        String[] stringNums = internet.split(" ");
        int[] interNums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            interNums[i] = Integer.parseInt(stringNums[i]);
        }

        String line3 = scanner.nextLine();
        String[] stringNum3 = line3.split(" ");
        int[] intNums3 = new int[stringNums.length];
        for (int i = 0; i < stringNum3.length; i++) {
            intNums3[i] = Integer.parseInt(stringNum3[i]);
        }

        int index=0;
        int summax=0;

        for (int i = 0; i < n-k; i++) {
            int sum=0;
            for (int j = 0; j < k; j++) {
                if (intNums3[i + j] != 1) {
                    sum = sum + interNums[i + j];
                }
            }

            if (sum > summax) {
                index=i;
                summax=sum;
            }
        }

        int num=0;

        for (int i = 0; i < k; i++) {
            intNums3[i+index]=1;
        }
        for (int i = 0; i < n; i++) {
            if (intNums3[i] != 0) {
                num = num + interNums[i];
            }
        }

        System.out.println(num);

    }
}
