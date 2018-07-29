package com.li.xmlParse;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
