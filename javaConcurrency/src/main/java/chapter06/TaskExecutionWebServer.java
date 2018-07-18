package chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static final int NTHREADS=100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(100);

        while (true) {
            final Socket connection=serverSocket.accept();
            Runnable task=new Runnable() {  //Runnable 不处理异常，callable 处理异常。
                @Override
                public void run() {
                    //handlerRequest (connection);
                }
            };
            exec.execute(task);  //将Runnable 交给executor
        }
    }
}
