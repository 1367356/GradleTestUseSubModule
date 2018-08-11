package com.li.biTeDaLu;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-10 18:53
 **/
public class Question1 {
    public static void main(String[] args){

        Class clazz = Question1.class.getClass();
        /**
         * txt文件中，例如  1 2 4 8 8    1是起始节点，2 相邻节点，4是1,2之间的权重，8是相邻节点，8是1,8之间的权重。
         */
        InputStream ins = clazz.getResourceAsStream("/biTeDaLu/question1.txt");
        Scanner scanner = new Scanner(ins);


        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] stringNums = line.split(" ");
            int[] intNums = new int[stringNums.length];
            for (int i = 0; i < stringNums.length; i++) {
                intNums[i] = Integer.parseInt(stringNums[i]);
            }
        }

    }
}
