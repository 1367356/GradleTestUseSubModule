package chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-15 20:21
 **/
public class LifecycleWebServer {

    private final ExecutorService executorService = null;

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (!executorService.isShutdown()) {
            try {
                final Socket conn=socket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        handlerRequest(conn);
                    }
                });
            }catch (Exception e){
                if (!executorService.isShutdown()) {
                    System.out.println("task submission rejected "+e);
                }
            }
        }
    }

    private void handlerRequest(Socket conn) {

    }
}
