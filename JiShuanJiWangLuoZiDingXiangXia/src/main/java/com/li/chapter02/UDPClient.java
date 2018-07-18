package com.li.chapter02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-11 21:55
 **/
public class UDPClient {
    public static void main(String[] args) throws IOException {
        String serverName = "localhost";
        SocketAddress socketAddress = new InetSocketAddress("localhost",8080);
        Socket socket = new Socket();
        socket.connect(socketAddress,8080);
        OutputStream outputStream = socket.getOutputStream();
        String str = "我是客户端";
        byte[] bytes = str.getBytes();
        outputStream.write(bytes);
        outputStream.flush();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes1 = new byte[1024];

        inputStream.read(bytes1);
        System.out.println(bytes);

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
