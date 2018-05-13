package chapter17.class09;

/**
 * 散列与散列码
 */
public class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        //return super.toString(); //返回对象的hashcode码
        return "Groundhog#"+number;
    }

}
