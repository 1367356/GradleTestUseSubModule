package com.li.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-23 09:51
 * 服务中心实现类
 **/
public class ServiceCenter implements Server{
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());  //创建多线程执行框架

    private static final HashMap<String, Class> serviceRegistry = new HashMap<>();

    private static boolean isRunning=false;

    private static int port;

    public ServiceCenter(int port) {
        this.port=port;
    }

    public void stop() {
        isRunning=false;
        executor.shutdown();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket();  //开启远程后台服务
        server.bind(new InetSocketAddress(port));  //绑定端口号
        System.out.println("start server");
        try {
            while (true) {
                executor.execute(new ServiceTask(server.accept()));
            }
        }finally {
            server.close();
        }
    }

    public void register(Class serviceInterface, Class impl) {
        serviceRegistry.put(serviceInterface.getName(), impl);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getPort() {
        return port;
    }

    private static class ServiceTask implements Runnable{

        Socket client;
        public ServiceTask(Socket accept) {
            client=accept;
        }

        @Override
        public void run() {
            ObjectInputStream input=null;   //输入参数，对象名，方法名，对齐进行序列化
            ObjectOutputStream output=null; //返回的序列化对象
            try {
                //将客户端发送的码流发序列化成对象，反射调用服务实现者，获取执行结果
                input=new ObjectInputStream(client.getInputStream());
                String serviceName=input.readUTF();  //服务名
                String methodName=input.readUTF();
                Class<?>[] parameterTypes= (Class<?>[]) input.readObject();
                Object[] arguments= (Object[]) input.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);  //获取服务类
                if (serviceClass == null) {
                    throw new ClassNotFoundException("not found" + serviceName);
                }
                Method method = serviceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

                //将执行结果反序列化，通过socket发送给客户端
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (output != null) {
                    try {
                        output.close();
                    }catch (Exception e){
                            e.printStackTrace();
                    }
                }
                if (input != null) {
                    try {
                        input.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
