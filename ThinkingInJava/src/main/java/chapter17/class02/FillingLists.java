package chapter17.class02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 填充容器
 */
public class FillingLists {
    public static void main(String[] args){
        List<StringAdress> list=new ArrayList<>(Collections.nCopies(4,new StringAdress("hello")));  //copy4个这样的对象，填充容器
        System.out.println(list);
        Collections.fill(list, new StringAdress("world"));  //用world替换容器中的内容
        System.out.println(list);
    }
}

class StringAdress{
    private String s;

    public StringAdress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString()+s;
    }
}
