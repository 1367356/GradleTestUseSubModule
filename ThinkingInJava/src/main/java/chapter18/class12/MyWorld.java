package chapter18.class12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久性
 */
public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house=new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("bosco the dog", house));
        animals.add(new Animal("alph the hamster", house));
        animals.add(new Animal("molly the cat", house));
        System.out.println("animals:" + animals);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals);
        //write a different stream
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);

        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        List animals1= (List) in1.readObject();
        List animals2= (List) in1.readObject();
        List animals3= (List) in1.readObject();
        System.out.println("animals1"+animals1);
        System.out.println("animals2"+animals2);
        System.out.println("animals3"+animals3);
        }
}

class House implements Serializable{

}
class Animal implements Serializable{
    private String name;
    private House preferedHouse;

    Animal(String nm, House house) {
        name=nm;
        preferedHouse=house;
    }

    @Override
    public String toString() {
        return super.toString()+name+preferedHouse;
    }
}
