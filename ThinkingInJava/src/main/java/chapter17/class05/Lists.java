package chapter17.class05;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * list操作
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1,"x");  //在位置1添加，但是位置1不能大于结尾长度
        a.add("x");//在结尾添加
        b=a.contains("1");//是否包含
        i = a.indexOf("1");  //1的角标
        lit=a.listIterator();//只针对list的方法
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it=a.listIterator();
        b=it.hasNext();
        b=it.hasPrevious();
        s=it.next();
        i=it.nextIndex();
        s=it.previous();
        i=it.previousIndex();
    }

    public static void itermanipulation(List<String> a) {
        ListIterator<String> it=a.listIterator();
        it.add("47");
        it.next();
        it.remove();
        it.next();
        it.set("47"); //改变元素
    }

    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
    }
}
