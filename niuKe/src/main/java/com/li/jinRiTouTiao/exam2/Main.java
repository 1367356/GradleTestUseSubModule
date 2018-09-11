package com.li.jinRiTouTiao.exam2;

import java.util.Scanner;

public class Main {

    private static int[] idarr;
    private static int number;
    public static void countnum(int N)
    {
        // Initialize component id array.
        number = N;
        idarr = new int[N];
        for (int i = 0; i < N; i++)
            idarr[i] = i;
    }
    public static void countNumber(int p, int q) {
        // Give p and q the same root.
        int parentRoot = countNumber(p);
        int qRoot = countNumber(q);
        if (parentRoot == qRoot)
            return;
        idarr[parentRoot] = qRoot;         number--;
    }
    private static int countNumber(int p)
    {
        while (p != idarr[p])
        {
            // 将p节点的父节点设置为它的爷爷节点
            idarr[p] = idarr[idarr[p]];
            p = idarr[p];
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        countnum(num);
        for(int i = 0; i < num; i++){
            String str = sc.nextLine();
            String strings[] = str.split(" ");
            for(String s : strings){
                if(s.equals("0"))
                    break;
                else{
                    countNumber(i, Integer.valueOf(s) - 1);
                }
            }
        }
        System.out.println(number);
    }

}
