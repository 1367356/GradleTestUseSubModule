package com.li.shenxinfu;

import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-21 18:51
 *
 * 小强想要抓兔子，但狡兔三窟。假设狡猾的兔子有n个排成一排的洞，编号分别是1到n。兔子每天晚上都要跳到相邻的一个洞里去住，而小强则会在每个白天检查其中一个洞。小强告诉你他每天要检查的洞，希望你帮忙分析是否一定可以抓住兔子。
比如兔子有3个洞，小强第一天检查2号洞，第二天继续检查2号洞，那么一定可以抓住兔子。
因为，假设兔子一开始在2号洞，那么第一天就会被抓到；假设一开始在1或3号洞，那么第二天它只会跳到相邻的2号洞中，从而还是会被抓到。

输入描述:
首先输入n和k（n，k<=1e3），分别表示洞的个数以及小强要检查的天数；
接下来输入k个整数，表示小强每天检查的洞编号。
输出描述:
对于每个样例，如果一定能抓到兔子，输出Yes，否则输出No
示例1
输入
3 2
2 2
输出
Yes
 **/
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

//        String line1 = scanner.nextLine();  //第一行
//        String[] line1Arr = line1.split(" ");
//
//        int n = Integer.parseInt(line1Arr[0]);  // 珠子个数
//        int m = Integer.parseInt(line1Arr[1]);  //距离
//        int c = Integer.parseInt(line1Arr[2]);  //颜色个数

        int tole=scanner.nextInt();//洞数
        int day=scanner.nextInt();

        String line1 = scanner.nextLine();  //第一行
         String[] lineArr = line1.split(" ");
        int[] dayArr = new int[day];  //洞编号

        for (int i = 0; i < day; i++) {
            dayArr[i]=Integer.parseInt(lineArr[i]);
        }

        //当兔子跳的的洞数= 那天检查的洞数时，就yes



    }
}
