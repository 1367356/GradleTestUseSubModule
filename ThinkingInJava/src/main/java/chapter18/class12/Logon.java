package chapter18.class12;

import java.beans.Transient;
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 瞬间关键字可以锁住某个字段，让其不能够序列化。例如下面的 login
 */
public class Logon {
    private Date date = new Date();
    private String userName;
    private transient String password;  //锁住这个字段，不能序列化和反序列化

    public Logon(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Logon a = new Logon("hulk", "myLittlePony");
        System.out.println("Logon a"+a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recoving object at" + new Date());

        a= (Logon) in.readObject();
        System.out.println("a"+a);  //password is null
    }
}
