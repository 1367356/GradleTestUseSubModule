package com.li.haoweilai;

import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-28 18:30
 **/
public class Main6 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String string=scanner.nextLine();
            String subString=scanner.nextLine();
            String newString=scanner.nextLine();
            String res=string.replaceAll(subString, newString);
            System.out.print(res);
        }


}
