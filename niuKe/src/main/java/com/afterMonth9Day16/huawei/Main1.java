package com.afterMonth9Day16.huawei;

import java.util.Calendar;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int d=scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2018);
        //month从0开始至11，代表1-12
        calendar.set(Calendar.MONTH,m-1);
        calendar.set(Calendar.DAY_OF_MONTH,d);

//        int month = calendar.get(Calendar.MONTH)+1;
        String weekday = getWeek(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(weekday);
    }
    public static String getWeek(int a){
        //西方的星期的开始为周日，中国为周一。
        String[] strings = {" ","7","1","2","3","4","5","6"};
        return strings[a];
    }
}