package com.li.jinRiTouTiao.exam3;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-09 09:55
 **/
public class Main1 {
    public static void main(String[] args){
        Class clazz = Main1.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/jinRiTouTiao/exam3/question1.txt");
        Scanner scanner = new Scanner(ins);

        String line=scanner.nextLine();

        if (line.length() == 0) {
            System.out.println(0);
            return;
        }
        int subMax=1;
        int max=0;

        Set<Character> set;
        List<Character> list;


        for (int i = 1; i < line.length(); i++) {
            if(line.charAt(i)!=line.charAt(i-1)){
                subMax++;
            }else {
                if (subMax > max) {
                    max=subMax;
                }
                subMax=1;
            }
        }
        System.out.println(max);
    }
}
