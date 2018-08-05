package com.li.chapter02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-11 22:40
 **/
public class UDPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,10, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        while (true) {
            Socket acceptSocket = serverSocket.accept();

            InputStream inputStream = acceptSocket.getInputStream();
            byte[] bytes = new byte[1024];
            int len=0;

            OutputStream outputStream = acceptSocket.getOutputStream();
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(bytes);
                outputStream.write(bytes);
            }
            acceptSocket.close();
        }
    }
}
