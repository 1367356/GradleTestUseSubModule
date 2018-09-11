package com.li.keDaXunFei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scannerInput = new Scanner(System.in);
        int sumDay = scannerInput.nextInt();
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < sumDay; i++) {
            lists.add(scannerInput.nextInt());
        }
        int pinganDay = 0;
        while (true) {
            int length =  lists.size();
            for (int i = lists.size()-1; i > 0; i--) {
                if (lists.get(i)<lists.get(i-1)) {
                    lists.remove(i);
                }
            }
            int oldLength = lists.size();
            if (length!=oldLength) {
                pinganDay++;
            }else {
                break;
            }
        }
        System.out.println(pinganDay);
    }
}
