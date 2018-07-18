package chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-13 21:05
 **/
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection=socket.accept();
            Runnable task=new Runnable() {
                @Override
                public void run() {
//                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }
}
