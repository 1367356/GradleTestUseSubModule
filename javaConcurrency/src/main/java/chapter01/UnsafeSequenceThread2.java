package chapter01;

public class UnsafeSequenceThread2 implements Runnable {

    UnsafeSequence unsafeSequence;
    public UnsafeSequenceThread2(UnsafeSequence unsafeSequence) {
        this.unsafeSequence=unsafeSequence;
    }

    @Override
    public void run() {
//        System.out.println("thread2");
//        int value = this.unsafeSequence.getValue();
//        System.out.println(value);
        int next = unsafeSequence.getNext();
        System.out.println("thread2--------------"+next);
    }
}
