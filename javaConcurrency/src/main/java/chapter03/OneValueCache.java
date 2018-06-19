package chapter03;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 不可变对象
 */
public class OneValueCache {
    private final BigInteger lastNumber;
//    private final BigInteger[] lastFactor;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactor) {
        this.lastNumber = lastNumber;
//        this.lastFactor = Arrays.copyOf(factors,factors.length);
    }
}
