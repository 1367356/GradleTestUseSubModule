package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi.july;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-01 15:48
 * 数字比较
 * https://www.nowcoder.com/question/next?pid=11488280&qid=201984&tid=17144331
 **/
public class NumberCompare {
    public static void main(String[] args) {
        Class clazz = JianNanDeXuanZhe.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi/NumberCompare.txt");

        Scanner scanner = new Scanner(ins);

        int x=scanner.nextInt();
        int y=scanner.nextInt();

        if (x <= 4 && y <= 4) {
            double x1 = Math.pow(x, y);
            double y1 = Math.pow(y, x);
            if (x1 > y1) {
                System.out.println(">");
                return;
            } else if (x1 < y1) {
                System.out.println("<");
                return;
            }else {
                System.out.println("=");
                return;
            }
        }

        if (x > y) {
            System.out.println("<");
        } else if (x < y) {
            System.out.println(">");
        }else {
            System.out.println("=");
        }

    }
}
