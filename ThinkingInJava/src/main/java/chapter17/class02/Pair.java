package chapter17.class02;

/**
 * map生成器
 */
public class Pair<K,V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
