package com.li.chapter03;

/**
 * 新生代GC
 */
public class MinorGC {

    private static final int _1MB=1024*1024;
    public static void main(String[] args){
        byte[] allocaton1,allocation2,allocation3,allocation4; //
        allocaton1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; //出现一次Minor GC

        /**
         * 运行结果
         * [GC (Allocation Failure) [PSYoungGen: 6616K->872K(9216K)] 6616K->4976K(19456K), 0.0087676 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
         Heap
         PSYoungGen      total 9216K, used 7253K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         eden space 8192K, 77% used [0x00000000ff600000,0x00000000ffc3b7d0,0x00000000ffe00000)
         from space 1024K, 85% used [0x00000000ffe00000,0x00000000ffeda020,0x00000000fff00000)
         to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         Metaspace       used 3456K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 376K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
