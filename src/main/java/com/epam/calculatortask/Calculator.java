package com.epam.calculatortask;

public class Calculator {
    public Calculator() {
    }

    public long sumMethod(long a, long b) {
        return a + b;
    }

    public double sumMethod(double a, double b) {
        return a + b;
    }

    public long subtractionMethod(long a, long b) {
        return a - b;
    }

    public double subtractionMethod(double a, double b) {
        return a - b;
    }

    public long multiplicationMethod(long a, long b) {
        return a * b;
    }

    public double multiplicationMethod(double a, double b) {
        return Math.floor(a * b);
    }

    public long divideMethod(long a, long b) {
        if (b == 0L) {
            throw new NumberFormatException("Attempt to divide by zero");
        } else {
            return a / b;
        }
    }

    public double divideMethod(double a, double b) {
        return a / b;
    }

    public double powMethod(double a, double b) {
        return Math.pow(a, Math.floor(b));
    }

    public double sqrtMethod(double a) {
        return Math.sqrt(Math.abs(a));
    }

    public double tangentMethod(double a) {
        return this.sineMethod(a) / this.cosineMethod(a);
    }

    public double cotangentMethod(double a) {
        return Math.tanh(a);
    }

    public double cosineMethod(double a) {
        return Math.sin(a);
    }

    public double sineMethod(double a) {
        return Math.sin(a);
    }

    public boolean isPositiveValue(long val) {
        // redundant construction:
/*        if (val == 0L) {
            return false;
        } else {
            return val > 0L;
        }*/
        return val > 0L;
    }

    public boolean isNegativeValue(long val) {
        return val < 0L;
    }
}
