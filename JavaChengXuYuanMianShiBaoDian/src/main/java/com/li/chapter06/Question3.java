package com.li.chapter06;
import java.util.*;
import java.io.*;

/**
 * 请给出一段代码描述字符串写入文件
 */
public class Question3 {
    public static void main(String[] args){
        try {
            OutputStream os = new FileOutputStream(new File("d://a.txt"));
            os.write("你好".getBytes());
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
