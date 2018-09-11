package com.li.jinRiTouTiao.exam3;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] charsArr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charsArr[i][j] = (char) (scanner.nextInt()+48);
            }

        }
        System.out.print(getlandNum(charsArr));
    }
    public static int getlandNum(char[][] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i ++) {
            for (int j = 0; j < chars[0].length; j ++) {
                if (chars[i][j] == '1') {
                    count ++;
                    isLand(chars, i, j);
                }
            }
        }
        return count;
    }

    public static void isLand(char[][] s, int i, int j) {
        if (i >= 0 && i < s.length && j >= 0 && j < s[0].length && s[i][j] == '1') {
            s[i][j] = '0';
            isLand(s, i+1, j);
            isLand(s, i-1, j);
            isLand(s, i, j+1);
            isLand(s, i, j-1);
        }
    }
}
