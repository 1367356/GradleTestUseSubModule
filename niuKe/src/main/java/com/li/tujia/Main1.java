package com.li.tujia;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = 0, n = 0, m = 0;
        a = scan.nextInt();
        while (true) {
            if (a > 0) {
                n = scan.nextInt();
                m = scan.nextInt();
                if (n % (m + 1) == 0) {
                    System.out.println("B");
                } else {
                    System.out.println("A");
                }
            } else
                break;
            a--;//自减操作
        }
    }
}
