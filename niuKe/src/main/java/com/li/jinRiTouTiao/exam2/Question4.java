package com.li.jinRiTouTiao.exam2;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-25 10:57
 **/
public class Question4 {
    public static void main(String[] args){
        Class clazz = Question4.class.getClass();
        InputStream ins = Question4.class.getResourceAsStream("/month9day16/jinRiTouTiao/question4.txt");
        Scanner scanner = new Scanner(ins);

        String s = scanner.nextLine();

        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int t = Integer.parseInt(split[1]);

        int length=n*t;

        int[] arri=new int[length];

        String s1 = scanner.nextLine();
        String[] split1 = s1.split(" ");

        for (int i = 0; i < split1.length; i++) {
            arri[i]=Integer.parseInt(split1[i]);
        }


        for (int i = 1; i < t; i++) {
            for (int j = 0; j < n; j++) {
                arri[i*n+j]=arri[j];
            }
        }

        int[][] douarr=new int[length][length];

        for (int i = 0; i < length; i++) {
            if(arri[i]>=arri[0] && i>0){
                douarr[0][i]=2;
            }else{
                douarr[0][i]=1;
            }
        }

        int max=0;
        for (int i = 1; i <length; i++) {
            for (int j = i; j < length; j++) {
                if(arri[j]>=arri[i] && (douarr[i][i]+1)>=douarr[i-1][j]){
                    douarr[i][j]=douarr[i][i]+1;
                    if (douarr[i][j] > max) {
                        max = douarr[i][j];
                    }
                }else{
                    douarr[i][j]=douarr[i-1][j];
                }
            }
        }

        System.out.println(max);

    }

    
}
