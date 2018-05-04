package chapter18.class10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对映射文件的加锁
 */
public class LockingMappedFiles {
    static final int LENGTH=0x8FFFFFFF;  //128Mb
    static FileChannel fc;
    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("test.dat", "rw").getChannel();

        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            out.put((byte)'x');
        }
        new LockAndModify(out,0,0+LENGTH/3);  //被锁的位置
        new LockAndModify(out,LENGTH/2,LENGTH/2+LENGTH/4);

    }

    private static class LockAndModify extends Thread{
        private ByteBuffer buffer;
        private int start,end;

        public LockAndModify(ByteBuffer buffer, int start, int end) {
            buffer.limit(end);
            buffer.position(start);
            this.buffer = buffer.slice();  //独占的片
            this.start = start;
            this.end = end;
            start();
        }

        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);  //锁的位置
                System.out.println("locked:"+start+"to"+end);
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte) (buffer.get() + 1));
                }
                fl.release();
            } catch (IOException e) {

            }
        }
    }
}
