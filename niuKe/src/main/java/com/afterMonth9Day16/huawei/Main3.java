package com.afterMonth9Day16.huawei;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-16 09:54
 **/
public class Main3 {
    public static void main(String[] args){

        Main3 main1=new Main3();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/huawei/data3");
        Scanner scanner = new Scanner(Systemin);

        String line = scanner.nextLine();
        System.out.println(line);

    }
}
