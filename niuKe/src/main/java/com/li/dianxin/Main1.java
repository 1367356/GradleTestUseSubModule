package com.li.dianxin;

import java.io.InputStream;
import java.util.Scanner;

public class Main1{

    public static void main(String[] args) {
        Class clazz = com.li.jingdong.Main1.class.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/dianxin/main1.txt");
        Scanner scanner = new Scanner(Systemin);
        String  line=scanner.nextLine();
        String[] split = line.split(" ");
        String strOne = split[0];
        String strTwo = split[1];

        int length=strOne.length()>strTwo.length()?strTwo.length():strOne.length();

        int onestart=0;
        int oneend=0;

//        System.out.println(strOne.substring(strOne.length()-1,strOne.length()));
//        System.out.println(strOne.substring(0,0));
        for (int i = 1; i <= length; i++) {
            if (strOne.substring(0, i) .equals( strTwo.substring(0, i))) {
                if (i > onestart) {
                    onestart=i;
                }
            }

            if (strOne.substring(0, i) .equals( strTwo.substring(strTwo.length()-i, strTwo.length()))) {
                if (i > onestart) {
                    onestart=i;
                }
            }

            if (strOne.substring(strOne.length()-i, strOne.length()) .equals( strTwo.substring(0, i))) {
                if (i > oneend) {
                    oneend=i;
                }
            }

            if (strOne.substring(strOne.length()-i, strOne.length()) .equals( strTwo.substring(strTwo.length()-i, strTwo.length()))) {
                if (i>oneend) {
                    oneend=i;
                }
            }


        }
        if (oneend > onestart) {
            System.out.println(oneend);
        }else {
            System.out.println(onestart);
        }
    }
}
