package chapter07.class1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-16 15:48
 **/
public class ReaderThread extends Thread{
    private static final int BUFSZ = 100;
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket=socket;
        this.in=socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
        }catch (Exception e){

        }finally {
            super.interrupted();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFSZ];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    processBuffer(buf, count);
                }
            }
        }catch (Exception e){

        }
    }

    private void processBuffer(byte[] buf, int count) {

    }
}
