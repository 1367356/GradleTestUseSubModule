package chapter17.class02;

import chapter17.class01.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args){
        Set<String> set = new LinkedHashSet<>(new CollectionData<String>(new Goverment(), 12));
        //使用government中的方法
        set.addAll(CollectionData.list(new Goverment(), 12));
        System.out.println(set);
        }
}

class Goverment implements Generator<String>{
    String[] foundation=("strange women lying in ponds").split(" ");

    private int index;
    @Override
    public String next() {
        return foundation[index++];
    }
}
