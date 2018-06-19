package com.li.chapter03;

/**
 * 此代码演示了两点：
 * 1.对象在被GC时自我拯救。
 * 2.这种自我拯救机会只有一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;

    public void isAlive() {
        System.out.println("yes, i am still alive:");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK=this;  //自我拯救。
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK=null;
        System.gc();  //系统调用垃圾回收。触发finalize，但是只触发一次。
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , i am dead1:");
        }

        SAVE_HOOK=null;
        System.gc();  //系统调用垃圾回收。
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , i am dead2:");
        }
    }
}
