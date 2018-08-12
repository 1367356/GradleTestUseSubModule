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
        
    }
}
