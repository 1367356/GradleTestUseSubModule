package comparableAndComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-10 16:18
 **/
public class Main {
    public static void main(String[] args){
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("wangwu"));
        linkedList.add(new Person("lisi"));
        linkedList.add(new Person("zhangsan"));
        linkedList.stream().forEach(person -> {
            System.out.println(person.name);
        });
        Collections.sort(linkedList,new PersonComparator());
        System.out.println("--------------------------");
        linkedList.stream().forEach(person -> {
            System.out.println(person.name);
        });
    }
}

class Person{

    public String name;

    public Person(String name) {
        this.name = name;
    }
}

class PersonComparator implements Comparator<Person>{
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }
}



