package ru.ivanovds.threads;

public class MyThread2 implements Runnable {

    private final String name;

    public MyThread2() {
        this.name = "MyThread2";
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
