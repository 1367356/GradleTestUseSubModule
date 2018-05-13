package chapter17.class09;

import java.util.*;

/**
 * 自定义散列map
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    //为map设定一个值，实现均匀分布
    static final int SIZE=997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];  //一个链表，存储相同键值

    public V put(K key, V value) {  //
        V oldValue=null;
        int index=Math.abs(key.hashCode())%SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);

        boolean found=false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K,V> iPair=it.next();
            if (iPair.getKey().equals(key)) {
                oldValue=iPair.getValue();
                it.set(pair);
                found=true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        HashMap hashMap;
        int index=Math.abs(key.hashCode())%SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
            return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry mPair : bucket) {
                set.add(mPair);
            }
        }
        return set;
    }

    public static void main(String[] args){
        SimpleHashMap<String,String> m=new SimpleHashMap<>();
        m.put("a", "aaa");
        System.out.println(m);
        System.out.println(m.entrySet());
    }
}
