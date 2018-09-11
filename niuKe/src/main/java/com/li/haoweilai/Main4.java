package com.li.haoweilai;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main4 {
    public static void main(String[] args){
        Main4 main1=new Main4();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/haoweilai/main4");
        Scanner scanner = new Scanner(Systemin);
        int i = scanner.nextInt();
        System.out.println(i);
    }
}
