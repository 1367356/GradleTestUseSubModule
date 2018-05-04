package chapter18.class10;

import java.nio.ByteBuffer;

import static sun.misc.Version.println;

/**
 * 获取基本类型
 */
public class GetData {
    private static final int BSIZE=1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        int i=0;
        while (i++ < bb.limit()) {
            if (bb.get()!=0) {
                System.out.println("nonzero");
            }
        }
        System.out.println(i);

        bb.rewind();  //清0
        bb.asCharBuffer().put("howdy");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.println(c);
        }

        bb.rewind();
        bb.asShortBuffer().put((short) 10002);
        System.out.println(bb.getShort());

    }
}
