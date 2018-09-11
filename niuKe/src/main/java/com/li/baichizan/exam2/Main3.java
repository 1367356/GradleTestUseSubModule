package com.li.baichizan.exam2;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main3 {


    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Main3 niuNiuYuNiuNiu=new Main3();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/baichizan/data3.txt");

    }
}