package com.li.baichizan.exam2;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 最长回文字符串
 */
public class Main2 {


    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Main2 niuNiuYuNiuNiu=new Main2();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/baichizan/data3.txt");
        Scanner sc = new Scanner(Systemin);

    }


}