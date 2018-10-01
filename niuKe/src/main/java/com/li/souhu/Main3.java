package com.li.souhu;

import java.io.InputStream;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Main3 niuNiuYuNiuNiu=new Main3();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/souhu/data1");
        Scanner scanner = new Scanner(Systemin);


    }
}