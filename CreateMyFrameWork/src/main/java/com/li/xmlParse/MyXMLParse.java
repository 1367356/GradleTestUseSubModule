package com.li.xmlParse;

import org.springframework.core.io.ClassPathResource;

import java.io.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 12:30
 **/
public class MyXMLParse {

    public static void main(String[] args) throws IOException {
        MyXMLParse myXMLParse=new MyXMLParse();
        String sql = myXMLParse.parse("select");
        System.out.println(sql);

    }


    public static String parse(String methodName) throws IOException {

        ClassPathResource cpr = new ClassPathResource("./MyBatisXmlFile");
        File file = cpr.getFile();

        String path = file.getPath();
        System.out.println(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
//
//
//        System.out.println(file);

        ClassPathResource classPathResource = new ClassPathResource("/UserMapper.xml");

        InputStream inputStream = classPathResource.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String str=null;
        String sql=null;
        while ((str = bufferedReader.readLine()) != null) {
            if(str.contains("id=\""+methodName+"\"")){
                sql=bufferedReader.readLine();
                break;
            }
        }
        return sql;
    }
}
