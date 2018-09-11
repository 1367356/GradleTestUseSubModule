package com.li.baichizan.exam2;


import java.io.InputStream;
import java.util.Scanner;

/**
 * 大数相乘
 * @author Ant
 *
 */
public class Main1 {

    public static void main(String[] args) {
        Main1 niuNiuYuNiuNiu=new Main1();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/baichizan/data1.txt");
        Scanner scanner = new Scanner(Systemin);

    }
}