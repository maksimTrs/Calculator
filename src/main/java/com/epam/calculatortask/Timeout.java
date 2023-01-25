package com.epam.calculatortask;


// unnecessary class - we can use annotation
// @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)

public class Timeout {
    public static void sleep(final long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

