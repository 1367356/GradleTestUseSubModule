package com.li.haoweilai;

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
        InputStream Systemin = clazz.getResourceAsStream("/haoweilai/main3");
        Scanner scanner = new Scanner(Systemin);
        int n=10;
        int[] arri = new int[n];
        for (int j = 0; j <n; j++) {
            arri[j]=scanner.nextInt();
        }

        int index=0;
        //递归
        recrusive(arri,index);
    }

    private static void recrusive(int[] arri, int index) {
        if (index == 10) {
            for (int i = 0; i < 10; i++) {
                if (arri[i]==0 && i!=0) {
                    continue;
                }
                System.out.print(i);
            }
            System.out.println("");
            return;
        }

        if (arri[index] == 0) {
            arri[index]=index;
            recrusive(arri,index+1);
            arri[index]=0;
            recrusive(arri,index+1);
        }else {
            recrusive(arri,index+1);
        }
    }
}
