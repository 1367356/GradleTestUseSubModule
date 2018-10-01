package com.li.zhaoyinwangluo;


import java.io.InputStream;
import java.util.Scanner;

/**

 */

public class Main3 {
    public static void main(String[] args){
        Main3 main1=new Main3();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/zhaoyin/data3.txt");
        Scanner scanner = new Scanner(Systemin);
        int n = scanner.nextInt();

    }
}