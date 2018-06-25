package chapter12;

import junit.framework.TestCase;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 08:20
 **/
public class BoundBufferTest extends TestCase {
    void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());  //断言，判断是否为空
        assertFalse(bb.isFull());
    }

    void testIsFullAfterPut() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    /**
     * 测试阻塞行为以及对中断的响应性
     */
    void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(){
            @Override
            public void run() {
                try {
                    int unused=bb.take();
                    fail();   //如果执行到这里，那么表示出现一个错误
                }catch (Exception e){
                    //出现异常
                }
            }
        };

        try {
            taker.start();
            Thread.sleep(100);
            taker.interrupted();
            taker.join(100);
            assertFalse(taker.isAlive());
        }catch (Exception e){
            fail();
        }
    }

    public static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }


}
