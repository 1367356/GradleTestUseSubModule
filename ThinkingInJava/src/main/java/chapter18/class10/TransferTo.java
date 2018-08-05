package chapter18.class10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * TransferTo 和  TransferFrom
 */
public class TransferTo {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments:sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0, in.size(), out);  //直接将in转到out


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        in.read(buffer);
        //对 buffer进行编码
        Charset.forName(System.getProperty("file.encoding")).decode(buffer);
    }
}
