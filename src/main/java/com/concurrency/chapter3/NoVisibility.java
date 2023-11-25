package com.concurrency.chapter3;

public class NoVisibility {

    private static volatile boolean ready;

    private static volatile int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new ReaderThread().start();
        }
        number = 42;
        ready = true;
    }

}
