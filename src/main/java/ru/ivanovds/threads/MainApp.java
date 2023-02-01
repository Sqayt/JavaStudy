package ru.ivanovds.threads;

import java.util.concurrent.Semaphore;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.decrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getValue());
    }
}

class Counter {
    private int c = 0;

    public void increment() {
        synchronized (this) {
            c++;
            System.out.println(Thread.currentThread().getName() + " " + c);
        }
    }

    public synchronized void decrement() {
        c--;
        System.out.println(Thread.currentThread().getName() + " " + c);
    }

    public synchronized int getValue() {
        return c;
    }
}

