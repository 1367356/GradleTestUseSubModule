package chapter01;

public class UnsafeSequenceThread1 implements Runnable{

    private UnsafeSequence unsafeSequence;
    public UnsafeSequenceThread1(UnsafeSequence unsafeSequence) {
            this.unsafeSequence=unsafeSequence;
    }

    @Override
    public void run() {
        int next = unsafeSequence.getNext();
        System.out.println("thread1-------------"+next);
//        System.out.println("thread1");
//        if (unsafeSequence.getValue() > 5) {
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        unsafeSequence.setValue(unsafeSequence.getValue());
    }
}
