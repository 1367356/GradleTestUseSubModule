package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi.july;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-01 09:48
 * 牛客网 艰难的选择
 * https://www.nowcoder.com/test/question/6e8c0647a227406e8ea8cd926416bbea?pid=11488280&tid=17144331
 *
 *
 **/
public class JianNanDeXuanZhe {
    public static void main(String[] args){
        Class clazz = JianNanDeXuanZhe.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi/JianNanDeXuanZhe.txt");

        Scanner scanner = new Scanner(ins);

        int num = scanner.nextInt();
        int sum=0;
        for (int i = 0; i < num; i++) {
            int value=scanner.nextInt();
            while (value % 2 == 0) {
                sum++;
                value=value/2;
            }
            
        }
        System.out.println(sum);
    }
}
