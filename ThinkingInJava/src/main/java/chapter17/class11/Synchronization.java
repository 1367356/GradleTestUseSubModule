package chapter17.class11;

import java.util.*;

/**
 * Collection或Map的同步控制
 * 生成同步容器
 */
public class Synchronization {
    public static void main(String[] args){
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>()); //同步容器
        List<String> list = Collections.synchronizedList(new ArrayList<>()); //同步List
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<>());//TreeSet是SortedSet的一种实现

        Map<String, String> m = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> sm = Collections.synchronizedSortedMap(new TreeMap<>());
    }
}
