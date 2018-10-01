package com.li.xunlei;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 * 红黑积木求和 - 后台开发工程师
题目描述：
有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。选出17块积木排成一排，使得任意相邻7块积木之和都小于0。如何挑选才能使17块积木之和最大，最大值是多少？

输入
正数A，负数B

A和B绝对值小于10000

输出
积木之和的最大值


样例输入
10 -61
样例输出
28
 **/
public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/xunlei/main2");
        Scanner scanner = new Scanner(Systemin);

        int A=scanner.nextInt();
        int B=scanner.nextInt();

        int bCount=1;
        while (Math.abs(bCount*B)<(7-bCount)*A){
            bCount++;
        }

        List<Integer> list = new ArrayList<>();

        while (list.size() < 17) {
            for (int i = 0; i < 7-bCount; i++) {
                if (list.size() < 17) {
                    list.add(A);
                }
            }
            for (int i = 0; i < bCount; i++) {
                if (list.size() < 17) {
                    list.add(B);
                }
            }
        }


        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        System.out.println(sum);
    }
}
