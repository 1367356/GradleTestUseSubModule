package com.li.haikangweishi;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/haikang/data2.txt");
        Scanner scanner = new Scanner(Systemin);



    }
}
