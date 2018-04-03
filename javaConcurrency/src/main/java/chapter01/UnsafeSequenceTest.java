//package chapter01;
//
//
//import org.junit.Test;
//
//import java.lang.ref.ReferenceQueue;
//import java.util.concurrent.FutureTask;
//
//public class UnsafeSequenceTest {
//
//    @Test
//    public void test1() {
//      for (int i=0;i<10;i++) {
//          UnsafeSequence unsafeSequence = new UnsafeSequence(i);
//
//            UnsafeSequenceThread1 unsafeSequenceThread1=new UnsafeSequenceThread1(unsafeSequence);
//           Thread thread1 = new Thread(unsafeSequenceThread1);
//           UnsafeSequenceThread2 unsafeSequenceThread2=new UnsafeSequenceThread2(unsafeSequence);
//            Thread thread2=new Thread(unsafeSequenceThread2);
//            thread1.start();
//            thread2.start();
//            thread1.run();
//            thread2.run();
//      }
//    }
//    @Test
//    public void test3() {
//          UnsafeSequence unsafeSequence = new UnsafeSequence(0);
//          for (int i=0;i<100;i++) {
//                UnsafeSequenceThread1 unsafeSequenceThread1=new UnsafeSequenceThread1(unsafeSequence);
//               Thread thread1 = new Thread(unsafeSequenceThread1);
//               UnsafeSequenceThread2 unsafeSequenceThread2=new UnsafeSequenceThread2(unsafeSequence);
//                Thread thread2=new Thread(unsafeSequenceThread2);
//                thread1.start();
//                thread2.start();
//                thread1.run();
//                thread2.run();
//          }
//    }
//
//    @Test
//    public void test2() {
//        UnsafeSequenceThread3 unsafeSequenceThread3=new UnsafeSequenceThread3();
//        Thread thread3=new Thread(unsafeSequenceThread3);
//        thread3.start();  //写到线程组里面，实现多线程
//        thread3.run();   //运行
//    }
//
//    @Test
//    public void test4() {
//        ThreadLocal threadLocal;
//        ReferenceQueue referenceQueue;
//
//    }
//}
