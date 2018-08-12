package com.li.jinRiTouTiao;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-12 09:48
 * 考试
 **/
public class Question2 {
    public static void main(String[] args){
        Class clazz = Question2.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/jinRiTouTiao/question2.txt");
        Scanner scanner = new Scanner(ins);

        String s = scanner.nextLine();

        int n=Integer.parseInt(s);
//        int n=scanner.nextInt();



        String[] strs = new String[n];

        int maxNum=0;
        for (int i = 0; i < n; i++) {
            String s1=scanner.nextLine();
            strs[i]=s1;
            String[] split = s1.split(";");
            int max=0;
            for (int j = 0; j < split.length; j++) {
                String[] strings=split[j].split(",");
                int k=Integer.parseInt(strings[0]);
                int f=Integer.parseInt(strings[1]);
                int g=k>f?k:f;
                max=max>g?max:g;
            }
            maxNum=maxNum>max?maxNum:max;
        }
        int[][] arr = new int[n][maxNum];

        for (int i = 0; i < n; i++) {
            String ss=strs[0];
            String[] split = ss.split(";");
            for (int j = 0; j < split.length; j++) {
                String[] strings=split[j].split(",");
                int k=Integer.parseInt(strings[0]);
                int f=Integer.parseInt(strings[1]);
                for (int l = k; l <= f-1; l++) {
                    arr[i][l]=1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            String ss=strs[i];
            String[] split = ss.split(";");
            for (int j = 0; j < split.length; j++) {
                String[] strings=split[j].split(",");
                int k=Integer.parseInt(strings[0]);
                int f=Integer.parseInt(strings[1]);
                for (int l = k; l <= f-1; l++) {
                    arr[i][l]=1;
                }
                for (int l = 0; l < maxNum; l++) {
                    arr[i][l]=arr[i-1][l]==1?arr[i-1][l]:arr[i][l];
                }

            }

        }


        int i=0;
        int count=0;
        StringBuffer sb=new StringBuffer();
        while (i<maxNum){
                if(arr[n-1][i]==1){
//                    System.out.print(i+",");
                    sb.append(i + ",");
                    while (i<maxNum) {
                        if (arr[n - 1][i] == 0) {
                            break;
                        }
                        i++;
                    }

                    sb.append(i+";");
//                    System.out.print(i+";");
                }else {

                  i++;
                }

        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));

        
    }
}
