package com.li.keDaXunFei;

import java.io.InputStream;
import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/kedaxunfei/data1.txt");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();

        System.out.println(n);

    }
}