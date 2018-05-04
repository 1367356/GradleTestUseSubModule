package chapter18.class06;

import java.io.*;

/**
 * 存储和恢复数据
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("d://a.txt")
        ));

        out.writeDouble(3.2343888);
        out.writeUTF("that was pi");
        out.writeDouble(83.238347743);
        out.writeUTF("square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));

        System.out.println(in.readDouble());
        //only readUTF() will recover the java-UTF String properly;
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
