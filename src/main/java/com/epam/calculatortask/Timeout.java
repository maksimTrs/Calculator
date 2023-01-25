package com.epam.calculatortask;

public class Timeout {
    public static void sleep(final long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

