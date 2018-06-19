package com.li.chapter08;

/**
 * -verbose:gc
 */
public class LocalVariable {
    public static void main(String[] args){
        test3();
    }

    public static void test1() {
        byte[] placeholder = new byte[1024 * 1024 * 64];
        System.gc();
        /**
         * [GC (System.gc())  68872K->66432K(125952K), 0.0013585 secs]
         [Full GC (System.gc())  66432K->66323K(125952K), 0.0076762 secs]
         */
    }

    public static void test2() {
        {
            byte[] placeholder = new byte[1024 * 1024 * 64];
        }
        System.gc();
        /**
         * [GC (System.gc())  68872K->66416K(125952K), 0.0015151 secs]
         [Full GC (System.gc())  66416K->66323K(125952K), 0.0071078 secs]
         */
    }
    public static void test3() {
        {
            byte[] placeholder = new byte[1024 * 1024 * 64];
        }
        int a=0;
        System.gc();
        /**
         [GC (System.gc())  68872K->66384K(125952K), 0.0014097 secs]
         [Full GC (System.gc())  66384K->787K(125952K), 0.0064486 secs]  /正确回收
         */
    }
}
