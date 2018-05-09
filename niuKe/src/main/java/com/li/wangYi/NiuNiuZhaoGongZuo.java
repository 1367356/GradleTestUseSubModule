package com.li.wangYi;

import java.util.Scanner;

/**
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 输入描述:
 每个输入包含一个测试用例。
 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 保证不存在两项工作的报酬相同。


 输出描述:
 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

 输入例子1:
 3 3
 1 100
 10 1000
 1000000000 1001
 9 10 1000000000
 */
public class NiuNiuZhaoGongZuo {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
//        if (scanner.nextLine()==null || scanner.nextLine()=="") {
//            return;
//        }
        String s = scanner.nextLine().toString();
        String[] ns = s.split(" ");
        int n = Integer.parseInt(ns[0]);
        int m = Integer.parseInt(ns[1]);

        int[] arr1=new int[n];   //工作难度,n个工作
        int[] arr2 = new int[n];    //工作报酬
        int[] arr3=new int[m];    //m个小伙伴的工作能力

        int index=0;
        while (scanner.hasNextLine()&&index<n) {
            String str = scanner.nextLine().toString();
            if(str.equals("")){
                break;
            }
            String[] dp = str.split(" ");
            int d = Integer.parseInt(dp[0]);  //难度
            int p = Integer.parseInt(dp[1]);  //价格
            arr1[index]=d;
            arr2[index]=p;
            index++;
        }
        String str = scanner.nextLine().toString();
        String[] ablitiys = str.split(" ");
        for (int i = 0; i <ablitiys.length ; i++) {
            int ablitiy = Integer.parseInt(ablitiys[i]);
            arr3[i]=ablitiy;
        }

        for (int i = 0; i < arr3.length; i++) {
            int money=0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr3[i] >= arr1[j]) {
                    money=arr2[j]>money?arr2[j]:money;
                }
            }
            System.out.println(money);
        }
    }
}
