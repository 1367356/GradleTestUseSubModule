package chapter18.class12;

import java.io.*;

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip1 b1=new Blip1();
        Blip2 b2=new Blip2();

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        //Now get them back
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1");
        Blip1 ib1= (Blip1) in.readObject();  //恢复b1.继承Externalizable, 恢复对象时，会调用构造器。如果构造器是私有的，就不可以恢复，所以可控

    }
}
