package chapter18.class10;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE=1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();

        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();

        fc=new RandomAccessFile("data.txt","rw").getChannel();  //指定读写功能。
        fc.position(fc.size());  //Move to the end
        fc.write(ByteBuffer.wrap("some".getBytes()));
        fc.close();

        fc=new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.println((char) buff.get());
        }
    }
}