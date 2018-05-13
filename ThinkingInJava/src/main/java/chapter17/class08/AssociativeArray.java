package chapter17.class08;

/**
 * 模仿Map
 */
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {  //构造函数中初始化二维数组
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index > pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args){
        AssociativeArray<String, String> map = new AssociativeArray<>(6);

        map.put("sky", "blue");
        map.put("grass", "green");

        try {
            map.put("extra", "object");
        }catch (Exception e){
            System.out.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("grass"));
    }
}
