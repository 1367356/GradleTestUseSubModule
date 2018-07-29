package com.li.mySpringFrameWork.FrameWork;

import com.li.mySpringFrameWork.rule.Intercepter;
import com.li.xmlParse.MyXMLParse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 12:01
 **/
public class DynamicProxyClass implements InvocationHandler {

    private Object target;
    private Intercepter intercepter;
    public Object bind(Object target, Intercepter interceptor) {
        this.target=target;
        this.intercepter=interceptor;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        intercepter.before();

        String sql = MyXMLParse.parse(method.getName());

        String URL="jdbc:mysql://127.0.0.1:3306/labweb?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="1367356";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("username"));
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();

        Object invoke = method.invoke(target, objects);


        return null;
    }
}




