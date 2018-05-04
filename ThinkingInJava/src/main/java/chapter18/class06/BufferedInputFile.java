package chapter18.class06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 打开一个文件用于字符输入
 */
public class BufferedInputFile {
    public static String read(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String s;
            StringBuilder sb = new StringBuilder();  //线程不安全，单线程下面大量的字符串操作 ，StringBuffer线程安全
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s);
            }
            bufferedReader.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args){
        System.out.println(read("BufferedInputFile.java"));
    }
}
