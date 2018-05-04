package chapter18.class10;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 缓冲区的细节
 */
public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1=buffer.get();
            char c2=buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }
    public static void main(String[] args){
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer=buffer.asCharBuffer();  //缓冲区转换
        charBuffer.put(data);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
    }
}
