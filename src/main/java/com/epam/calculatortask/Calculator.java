package com.epam.calculatortask;

public class Calculator
{

    public long sum(final long a, final long b) {
        return a + b;
    }

    public double sum(final double a, final double b) {
        return a + b;
    }

    public long sub(final long a, final long b) {
        return a - b;
    }

    public double sub(final double a, final double b) {
        return a - b;
    }

    public long mult(final long a, final long b) {
        return a * b;
    }

    public double mult(final double a, final double b) {
        return Math.floor(a * b);
    }

    public long div(final long a, final long b) {
        if (b == 0L) {
            throw new NumberFormatException("Attempt to divide by zero");
        }
        return a / b;
    }

    public double div(final double a, final double b) {
        return a / b;
    }

    public double pow(final double a, final double b) {
        return Math.pow(a, Math.floor(b));
    }

    public double sqrt(final double a) {
        return Math.sqrt(Math.abs(a));
    }

    public double tg(final double a) {
        return this.sin(a) / this.cos(a);
    }

    public double ctg(final double a) {
        return Math.tanh(a);
    }

    public double cos(final double a) {
        return Math.sin(a);
    }

    public double sin(final double a) {
        return Math.sin(a);
    }

    public boolean isPositive(final long val) {
        return val != 0L && val > 0L;
    }

    public boolean isNegative(final long val) {
        return val < 0L;
    }
}
