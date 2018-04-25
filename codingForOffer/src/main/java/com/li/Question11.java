package com.li;

/**
 * 数值的整数次方。
 */
public class Question11 {
    
    boolean invalidInput=false;

    public double power(double base, int exponent) {
        invalidInput=false;
        if (equal(base, 0.0) && exponent < 0) {
            invalidInput=true;
            return 0.0;
        }
        int absExponent=exponent;//求指数的绝对值
        if (exponent < 0) {
            absExponent=-exponent;
        }
        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result=1.0/result;
        }
        return result;
    }

//    /**
//     * 改进算法，效率更高
//     * @param base
//     * @param absExponent
//     * @return
//     */
//    private double powerWithUnsignedExponent(double base, int absExponent) {
//        if (absExponent == 0) {
//            return 1;
//        }
//        if (absExponent == 1) {
//            return base;
//        }
//        double result = powerWithUnsignedExponent(base, absExponent >> 1);
//        result=result*result;
//        if (absExponent & 1 == 1) {
//            result=result*base;
//        }
//        return result;
//    }

    private double powerWithUnsignedExponent(double base, int absExponent) {
        double result=1.0;
        for (int i = 1; i < absExponent; i++) {
            result=result*base;
        }
        return result;
    }

    private boolean equal(double base, double v) {
        if (base - v > -0.000000001 && base - v < 0.00000001) {
            return true;
        }else {
            return false;
        }
    }
}
