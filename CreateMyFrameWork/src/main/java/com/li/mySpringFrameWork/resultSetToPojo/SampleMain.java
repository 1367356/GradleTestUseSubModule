package com.li.mySpringFrameWork.resultSetToPojo;

import java.sql.*;
import java.util.List;
public class SampleMain {
    public static void main(String ...args){
        try {
            String sql="select * from labweb.user";
            ResultSetMapper<User> resultSetMapper = new ResultSetMapper<User>();
            String URL="jdbc:mysql://127.0.0.1:3306/labweb?useUnicode=true&amp;characterEncoding=utf-8";
            String USER="root";
            String PASSWORD="1367356";
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库链接
            Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            Statement st=conn.createStatement();
            ResultSet resultSet=st.executeQuery(sql);

            /******************************/
            List<User> pojoList = resultSetMapper.mapRersultSetToObject(resultSet, User.class);
            /******************************/
            if(pojoList != null){
                for(User pojo : pojoList){
                    System.out.println(pojo);
                }
            }else{
                System.out.println("ResultSet is empty. Please check if database table is empty");
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}