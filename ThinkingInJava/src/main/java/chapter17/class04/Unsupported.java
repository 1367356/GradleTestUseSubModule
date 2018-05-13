package chapter17.class04;


import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("---"+msg+"---------");
        Collection c=list;
        Collection<String> subList = list.subList(1, 4);
        //复制子数组
        Collection<String> c2 = new ArrayList<>(subList);

        try {
            c.retainAll(c2);
        }catch (Exception e){
            System.out.println("retainAll" + e);
        }
        try {
            c.clear();
        }catch (Exception e){
            System.out.println("retainAll" + e);
        }
        try {
            c.addAll(c2);
        }catch (Exception e){
            System.out.println("retainAll" + e);
        }
    }
    public static void main(String[] args){
        //Arrays.asList会产生一个list,它基于一个固定大小的数组，改变数组大小的操作都是不支持的。
        List<String> list= Arrays.asList("A,B,C ,CC,C,C,,DJKGAFDKG A DS FDA SKAF ".split(" "));
        test("modifiable copy", new ArrayList<>(list));
        test("arrays.asList", list);
        test("unmodifiableList", Collections.unmodifiableList(new ArrayList<>(list)));  //不可修改的list
    }
}
