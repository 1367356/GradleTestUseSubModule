package com.li.shenxinfu;

import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-21 18:51
 **/
public class Main4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();  //第一行

        int length=line1.length();

        int max=0;
        for (int i = 0; i < length; i++) {
            int i1 = line1.charAt(i);  //找一个字符
            for (int j = i+1; j < i+(length-i)/2; j++) {
                if (line1.charAt(j)==i1) {
                    if (j - i > length - j) {
                        continue;
                    }else {
                        if (line1.substring(i,j).equals(line1.substring(j,j+(j-i)))) {
                            if (max < (j - i)*2) {
                                max=(j-i)*2;
                            }
                        }

                    }
                }
            }
        }
        System.out.println(max);

    }
}
