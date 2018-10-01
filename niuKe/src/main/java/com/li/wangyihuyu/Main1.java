package com.li.wangyihuyu;

import java.io.InputStream;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Main1 niuNiuYuNiuNiu=new Main1();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/wangyihuyu/data1");
        Scanner scanner = new Scanner(Systemin);


    }
}