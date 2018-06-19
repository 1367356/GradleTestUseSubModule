package com.li.chapter02;

/**
 * 栈溢出测试
 * 线程请求的最大栈深度大于虚拟机所允许的最大深度，抛出Stack Overflow error
 * -Xss128k      指定栈的大小，最小为108k
 * Error: Could not create the Java Virtual Machine.

 Error: A fatal exception has occurred. Program will exit.
 The stack size specified is too small, Specify at least 108k
 */
public class JavaVMStackSOF {

    private int stackLength=1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom=new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);  //stack length:20118
            throw e;
        }
    }

}
