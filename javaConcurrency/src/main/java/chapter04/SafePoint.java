package chapter04;

/**
 * 车辆跟踪线程安全的类
 */
public class SafePoint {
    private int x,y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(int i, int i1) {
        this.x=i;
        this.y=i1;
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public synchronized int[] get() {
        return new int[]{x,y};
    }

    public synchronized void set(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
