package chapter17.class11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * List排序和查询
 */
public class ListSortSearch {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println(list);
        Collections.shuffle(list, new Random());
        System.out.println("shuffled: " + list);
        Collections.sort(list);
        System.out.println("Sorted: "+list);
    }
}
