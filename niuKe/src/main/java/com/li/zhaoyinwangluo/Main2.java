package com.li.zhaoyinwangluo;


import java.io.InputStream;
import java.util.Scanner;

/**
 * 用最少的容器装完珍珠
 6 40   --  6 珍珠数量，40 一个容器大小
 12 14 20 18 11 10  -- 珍珠的大小
 */

public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/zhaoyin/data2.txt");
        Scanner scanner = new Scanner(Systemin);
        int n = scanner.nextInt();

    }
}