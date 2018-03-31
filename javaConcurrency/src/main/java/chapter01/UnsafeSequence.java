package chapter01;

public class UnsafeSequence {
    public int value;

    public int next=0;
    public UnsafeSequence(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNext() {
        return next++;
    }
}
