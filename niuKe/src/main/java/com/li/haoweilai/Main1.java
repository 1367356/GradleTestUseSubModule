package com.li.haoweilai;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main1 {
    public static void main(String[] args){
        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/haoweilai/main1");
        Scanner scanner = new Scanner(Systemin);

        String s = scanner.nextLine();

        int num=0;
        int sum=0;

        for (int j = 0; j < s.length(); j++) {
            char c=s.charAt(j);
            int i1 = Integer.parseInt("" + c);
            sum=i1+sum;
            if (sum % 3 == 0) {
                num++;
                sum=0;
            }

        }
        char c1=s.charAt(0);
        int i1 = Integer.parseInt("" + c1);
        if (i1 == 0) {
            num=num-1;
        }
        if (sum != 0) {
            num=num-1;
        }
        System.out.println(num);

    }
}
