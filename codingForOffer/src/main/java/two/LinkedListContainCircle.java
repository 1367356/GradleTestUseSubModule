package two;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-04 21:41
 *
 *  判断链表是否有环和计算环的长度   https://www.cnblogs.com/ghimtim/p/4882916.html
 **/
public class LinkedListContainCircle {
    static class Node{
        Node next;
    }

    /**
     * 判断是否有环
     * @param node
     * @return
     */
    public boolean isContainsCircle(Node node) {

        Node fast=node;
        Node slow=node;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }

    /**

     当n小于2时，。

     * @param head
     * @return
     */
    public int getDistanceOffIn(Node head) {
        Node fast=head;
        Node slow=head;

        while (fast != null && slow != null) {
            if (fast == slow) {
                break;
            }else {
                fast=fast.next.next;
                slow=slow.next;
            }
        }

        slow=head;
        int distance=0;
        while (slow != fast) {
            distance++;
            slow=slow.next;
            fast=fast.next;
        }
        return distance;
    }

}
