package com.li;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 20:05
 **/
public class Test {

    static int k;
    public static void main(String args[]) {
        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
    }

    private static void test() throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        systemClassLoader.loadClass("");
        for (int j = 0; j < 10; j++) {
            System.out.println(k++);
        }
    }
}
