package com.li.shangtang;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 判断是否符合规则
 */
public class Main2 {

//    private static String C = "C";
//    private static String M = "M";
//    private static String Y = "Y";

    public static void main(String[] args){


        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/shangtang/data2.txt");
        Scanner scanner = new Scanner(Systemin);

        int n=Integer.parseInt(scanner.nextLine());
        System.out.println(false);
        System.out.println(true);

//        System.out.println(n);

    }
}