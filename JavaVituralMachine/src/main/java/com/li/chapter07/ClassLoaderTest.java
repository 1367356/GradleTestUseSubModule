package com.li.chapter07;

import java.io.InputStream;

/**
 * 类加载器与instanceof关键字演示
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader myLoader=new ClassLoader() {  //定义一个类加载器,  类的唯一性由类加载器和类共同决定，而不是由虚拟机决定
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);  //加载字节流
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (Exception e){
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj=myLoader.loadClass("com.li.chapter07.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);

        /**
         * 结果：
         * class com.li.chapter07.ClassLoaderTest
           false
         */
    }
}
