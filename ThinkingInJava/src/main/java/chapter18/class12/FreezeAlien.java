package chapter18.class12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("x.file"));
            Alien quellek=new Alien();
            out.writeObject(quellek);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
