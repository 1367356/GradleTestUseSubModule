package com.li.xiecheng;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        int num = 0;
        while(number!= 0){
            num++;
            number= number & (number - 1);
        }

        System.out.print(num);
    }

}
