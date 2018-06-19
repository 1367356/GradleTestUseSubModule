package chapter04;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过线程封闭机制来确保线程安全
 */
public class PersonSet {

    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containsPerson(Person person) {
        return mySet.contains(person);
    }

}
