package com.li.chapter06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
