package chapter18.class11;

import java.io.*;
import java.util.Random;

public class Worm implements Serializable {

    private static Random random = new Random();
    private Data[] d = {new Data(random.nextInt()),new Data(random.nextInt()),new Data(random.nextInt())};
    private Worm next;
    private char c;

    //Value of i==number of segments;
    public Worm(int i, char x) {
        System.out.println("Worm Constructor"+i);
        c=x;
        if (--i > 0) {
            next=new Worm(i, (char) (x+1));
        }
    }

    public Worm() {
        System.out.println("Default Constructor");
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder(":");
        result.append(c);
        result.append("(");
        return result.toString();
    }

    //实现序列化与反序列化
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * 写入序列化对象
         */
        Worm w = new Worm(6, 'a');
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();  //also flushes output;

        /**
         * 读取序列化对象
         */
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s=(String)in.readObject();
        Worm w2= (Worm) in.readObject();
        System.out.println(s+"w2="+w2);

        /**
         * 将序列化对象写入到缓存流中
         */
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("worm storage\n");
        out2.writeObject(w);  //序列化对象一直存在
        out2.flush();

        //将缓冲流中的数据读取出来
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s= (String) in2.readObject();
        Worm w3= (Worm) in2.readObject();
        System.out.println(s+"w3"+w3);

    }

}
