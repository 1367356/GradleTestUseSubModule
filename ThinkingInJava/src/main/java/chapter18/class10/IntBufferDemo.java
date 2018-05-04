package chapter18.class10;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 视图缓冲器
 */
public class IntBufferDemo {
    private static final int BSIZE=1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib=bb.asIntBuffer();

        ib.put(new int[]{3,4,5});
        //根据位置读和写
        ib.get(2);
        ib.put(2, 1000);
        ib.flip();
        while (ib.hasRemaining()) {
            int i=ib.get();
            System.out.println(i);
        }
    }
}
