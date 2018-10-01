package com.afterMonth9Day16.didi;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-16 09:54
 **/
public class Main1 {
    public static void main(String[] args){

        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/didi/data1");
        Scanner scanner = new Scanner(Systemin);

        String line = scanner.nextLine();
        System.out.println(line);

    }
}
