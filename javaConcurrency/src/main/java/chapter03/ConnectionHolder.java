package chapter03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用ThreadLocal来维持线程封闭性
 */
public class ConnectionHolder {
    /**
     * ThreadLocal为该线程保存值和值的对象.
     * 为该线程创建一个保存Connection对象的ThreadLocal类。每个线程调用为每个线程创建
     */

    private static ThreadLocal<Connection> connectionHolder=new ThreadLocal<Connection>(){
        public Connection initialValue() {
            try {
                return DriverManager.getConnection("DB_URL");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();  //线程获得一个连接
    }
}
