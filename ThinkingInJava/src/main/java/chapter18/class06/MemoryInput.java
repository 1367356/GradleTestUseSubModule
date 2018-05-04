package chapter18.class06;

import java.io.IOException;
import java.io.StringReader;

/**
 * 读取字符输出到控制台
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {    //每次读取一个字符。
            System.out.println(c);
        }
    }
}
