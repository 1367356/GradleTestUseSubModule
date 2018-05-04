package chapter18.class06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    static void display() {
        try{
            RandomAccessFile rf = new RandomAccessFile(file, "r");
            for (int i = 0; i <7 ; i++) {
                System.out.println(rf.readDouble());
            }
            System.out.println(rf.readUTF());
            rf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "w");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i*12.33);
        }
        rf.writeUTF("the end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "w");
        rf.seek(5 * 8);  //第5个double值，因为每个double值是8字节长
        rf.writeDouble(47.00001);
        rf.close();
        display();
    }

}
