package com.li.jinRiTouTiao.exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3{
    public static void main(String[] args) {
        //["0.10.0.10","0.100.1.0"]
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();

        System.out.println(ipAddr(line).size());
    }
    static List<String> lists =new ArrayList<>();
    public static List<String> ipAddr(String line) {

        lists = new ArrayList<>();
        if(line.length() == 0) {
            return lists;
        }
        getIpAddr("", line);
        return lists;
    }

    private static void getIpAddr(String ipid, String line) {
        int n = 0;
        for (int i = 0; i < ipid.length(); i++) {
            if(ipid.charAt(i) == '.') {
                n++;
            }
        }
        if(n == 3) {
            if(ipid.length() - 3 < line.length()) {
                String sub = line.substring(ipid.length() - 3);
                if(sub.length() >= 4) {
                    return;
                }
                if(sub.length() != 1 && sub.charAt(0) == '0') {
                    return;
                }
                if(Integer.valueOf(sub) >= 0 && Integer.valueOf(sub) <= 255) {
                    lists.add(ipid + sub);
                    return;
                }else {
                    return;
                }
            }else {
                return;
            }
        }
        String[] nextStr = new String[3];
        for (int i = 0; i < 3; i++) {
            if(ipid.length() - n + i + 1 <= line.length()) {
                nextStr[i] = line.substring(ipid.length() - n, ipid.length() - n + i + 1);
                if(nextStr[i].length() != 1 && nextStr[i].charAt(0) == '0') {
                    continue;
                }
                if(Integer.valueOf(nextStr[i]) >= 0 && Integer.valueOf(nextStr[i]) <= 255) {
                    getIpAddr(ipid + nextStr[i] + ".", line);
                }
            }
        }
        return;
    }


}