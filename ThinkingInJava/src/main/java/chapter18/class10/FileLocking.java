package chapter18.class10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl=fos.getChannel().tryLock();  //锁住文件
        if (fl != null) {
            System.out.println("locked file");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("released lock");
        }
        fos.close();
    }
}
