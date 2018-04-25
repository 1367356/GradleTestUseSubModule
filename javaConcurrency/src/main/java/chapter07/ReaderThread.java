package chapter07;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReaderThread extends Thread {
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            super.interrupt();
        }
    }

    public void run() {
        int BUFSZ=10;

        try {
            byte[] buf = new byte[BUFSZ];
            while (true) {
                int count=in.read(buf);
                if (count < 0) break;
                else if (count > 0) {
                    //processBuffer(buf,count);
                }
            }
        } catch (IOException e) {
            //允许线程退出
            e.printStackTrace();
        }
    }

}
