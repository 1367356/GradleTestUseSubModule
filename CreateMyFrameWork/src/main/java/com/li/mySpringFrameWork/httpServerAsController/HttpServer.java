package com.li.mySpringFrameWork.httpServerAsController;

import com.li.mySpringFrameWork.utils.RegisterControllerAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    public static void main(String[] args) throws IOException {

        //注册controller
        RegisterControllerAnnotation registerControllerAnnotation=new RegisterControllerAnnotation();
        registerControllerAnnotation.controllerPathInjectToMap(MyController.class);
        Map<String, Map<Method, Class>> controllerInjectToMap = registerControllerAnnotation.getControllerInjectToMap();

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        ServerSocket serverSocket = null;

            serverSocket = new ServerSocket(8080, 10);
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        try {
                        //https://www.cnblogs.com/xzmblog/p/4505237.html 对路径进行处理
                            Object obj=null;
                        System.out.println("连接服务器成功！！...");

                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));

                        // GET /test.jpg /HTTP1.1
                        String line = reader.readLine();

                        System.out.println("打印line: " + line);  //line: GET /hello/mapping HTTP/1.1
                            String resource=null;
                            String substring=null;
                            if (line.contains("?")) {  //包含参数
                                resource = line.substring(line.indexOf('/'),
                                        line.lastIndexOf('?'));
                                 substring = line.substring(line.indexOf('?')+1,line.lastIndexOf('/')-5);  //参数
                            }else {
                                 resource = line.substring(line.indexOf('/'),  //无参数情况
                                    line.lastIndexOf('/') - 5);
                            }


//                            http://localhost:8080/index/2?name=name&password=password
//                            System.out.println("resource"+resource);
                            try {

                            }catch (Exception e){

                            }
                            if (substring == null) {  //处理/favicon.ico
                                return;
                            }
                            System.out.println("substring"+substring);
                            String[] parameters=parameters = substring.split("&");
                            Set set = new TreeSet();
                            String parameter=null;
                            for (int i = 0; i < parameters.length; i++) {
                                 parameter = parameters[i].substring(parameters[i].indexOf("=")+1);
                                 set.add(parameter);
                            }
                            Object returnObject=null;
                            resource = URLDecoder.decode(resource, "UTF-8");

                            if (controllerInjectToMap.containsKey(resource)) {
                                Map<Method, Class> methodClassMap = controllerInjectToMap.get(resource);
                                Set<Method> methods = methodClassMap.keySet();
                                Iterator<Method> iterator = methods.iterator();
                                while (iterator.hasNext()) {
                                    Method method = iterator.next();
                                    Class<?> returnType = method.getReturnType();
                                    Object o = returnType.newInstance();
                                    Class aClass = methodClassMap.get(method);
                                    System.out.println("name"+aClass.getName());
                                    try {
                                        Object[] objects = set.toArray();
                                        System.out.println(returnType);
                                        o =  method.invoke(aClass.newInstance(), objects);
                                        System.out.println(o);
                                        returnObject=o;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        if (resource.endsWith("/hello/mapping")) {
                            System.out.println("hello Mapping");
                        }

                        OutputStream os = socket.getOutputStream();

                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
//                        os.write("Content-Length:44\r\n".getBytes());
                        os.write("Server:gybs\r\n".getBytes());
                        os.write(("Date:"+new Date()+"\r\n").getBytes());
                        os.write("\r\n".getBytes());

                        os.write(returnObject.toString().getBytes("utf-8"));
                        os.write("<h3>HTTP服务器!</h3>".getBytes("utf-8"));

                        os.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                executorService.execute(runnable);
            }

    }
}