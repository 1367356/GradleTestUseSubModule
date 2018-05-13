package chapter17.class07;

/**
 * 双向队列测试
 */
public class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 0; i < 3; i++) {
            deque.addFirst(i);
        }

        for (int i = 52; i < 55; i++) {
            deque.addLast(i);
        }
    }
    public static void main(String[] args){
        Deque<Integer> di=new Deque<>();
        fillTest(di);
        System.out.println(di);
        while (di.size() != 0) {
            System.out.println(di.removeFirst()+" ");
        }
        System.out.println(" ");
        fillTest(di);
        ;        while (di.size() != 0) {
            System.out.println(di.removeLast()+" ");
        }
    }
}
