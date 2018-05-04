package chapter18.class12;

import java.io.*;

public class SerialCtl implements Serializable {
        private String a;
        private transient String b;

    public SerialCtl(String a, String b) {

        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b= (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("test1", "test2");
        System.out.println("sc");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2= (SerialCtl) in.readObject();
        System.out.println(sc2);
    }
}
