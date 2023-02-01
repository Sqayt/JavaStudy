package ru.ivanovds.threads.philosopher;

import java.util.concurrent.Semaphore;

public class App {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new Philosopher(sem, "Sokrat").start();
        new Philosopher(sem, "Plathon").start();
        new Philosopher(sem, "Aristotel").start();
        new Philosopher(sem, "Phales").start();
        new Philosopher(sem, "Pifagor").start();
    }
}


class Philosopher extends Thread {
    private final Semaphore sem;

    private boolean full = false;

    private final String name;

    public Philosopher(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!full) {
                sem.acquire();
                System.out.println(name + " сел за стол");

                sleep(300);
                full = true;

                System.out.println(name + " поел! Он выходит со стола");
                sem.release();

                sleep(300);
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
