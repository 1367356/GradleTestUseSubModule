package chapter18.class06;

import java.io.*;

/**
 * Writer作基本的文件输出
 */
public class BasicFileOutput {

    static String file="BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new FileWriter(file));  //输出
        int lineCount=1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ":" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
