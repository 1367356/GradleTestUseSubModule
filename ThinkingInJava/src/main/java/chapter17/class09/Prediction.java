package chapter17.class09;

import java.util.Random;

/**
 * 散列与散列码
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "six more weeks of winter";
        }else {
            return "early spring";
        }
    }
}
