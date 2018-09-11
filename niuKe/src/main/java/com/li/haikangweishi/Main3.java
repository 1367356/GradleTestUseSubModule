package com.li.haikangweishi;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main3 {
    public static void main(String[] args){
        Main3 main1=new Main3();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/haikang/data3.txt");
        Scanner scanner = new Scanner(Systemin);



    }
}
