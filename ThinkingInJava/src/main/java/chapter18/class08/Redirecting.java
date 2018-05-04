package chapter18.class08;

import java.io.*;

/**
 * 标准IO重定向
 */
public class Redirecting {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream console=System.out;

        BufferedInputStream in = new BufferedInputStream(new FileInputStream("Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));

        System.setIn(in);  //重定向
        System.setOut(console);
        System.setErr(out);


    }
}
