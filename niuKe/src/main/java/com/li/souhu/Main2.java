package com.li.souhu;

import java.io.InputStream;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Main2 niuNiuYuNiuNiu=new Main2();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/souhu/data1");
        Scanner scanner = new Scanner(Systemin);


    }
}