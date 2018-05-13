package chapter17.class09;

/**
 * 使用自己创建的对象，必须覆盖hashCode和equals方法
 */
public class Groundhog2 extends Groundhog {

    public Groundhog2(int number) {
        super(number);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2) o).number);
    }

}
