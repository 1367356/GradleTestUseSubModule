package com.afterMonth9Day16.tengxun;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-16 09:55
 **/
public class Main3 {
    public static void main(String[] args){
        Main3 main1=new Main3();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/tengxun/data3");
        Scanner scanner = new Scanner(Systemin);
        int nextInt = scanner.nextInt();
        System.out.println(nextInt);
    }
}




