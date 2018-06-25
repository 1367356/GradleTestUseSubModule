package chapter15;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 21:28
 **/
public class CasNumberRange {
    private static class IntPare{
        final int lower; //不变性条件；lower<=upper
        final int upper;

        public IntPare(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    private final AtomicReference<IntPare> values = new AtomicReference<>(new IntPare(0, 0));  //原子引用

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPare oldv=values.get();
            if (i > oldv.upper) {
                throw new IllegalArgumentException("can't set lower to");
            }
            IntPare newv = new IntPare(i, oldv.upper);
            if (values.compareAndSet(oldv, newv)) {
                return;
            }
        }
    }
}
