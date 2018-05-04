package chapter18.class08;

import java.io.PrintWriter;

/**
 * 将System.out 转换成PrintWriter
 */
public class ChangeSystemOut {
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hello, world");
//        System.out.println("");
    }
}
