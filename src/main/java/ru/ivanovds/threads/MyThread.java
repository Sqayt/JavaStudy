package ru.ivanovds.threads;

import ru.ivanovds.threads.data.Resource;

public class MyThread extends Thread {

    public MyThread() {
        this.setName(this.getClass().getName());
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; ++i) {
            Resource.incNumb();
        }
    }
}
