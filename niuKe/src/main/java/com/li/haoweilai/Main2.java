package com.li.haoweilai;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main2 {
    public static void main(String[] args) {
        Main5 main1=new Main5();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/haoweilai/main2");
        Scanner myScanner = new Scanner(Systemin);
        int num = myScanner.nextInt();

        int[] arri = new int[num];
        for (int i = 0; i < num; i++) {
            int myNum = myScanner.nextInt();
            int kNum = myScanner.nextInt();
            int Numj = 1;
            int sum = 0;
            for (; Numj <= myNum; Numj++) {
                if (Numj+myNum==(Numj|myNum)) {
                    sum++;
                    if (sum>=kNum) {
                        break;
                    }
                }
            }
            arri[i]=Numj;
        }
        for (int t = 0; t < num;t++) {
            System.out.println(arri[t]);

        }
    }

}
