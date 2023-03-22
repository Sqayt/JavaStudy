package ru.ivanovds.threads.executorsServices;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyService {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(new Thread(new MyRunnableInc()));
        service.execute(new Thread(new MyRunnableDiv()));
        service.execute(new Thread(new MyRunnableInc()));
        service.execute(new Thread(new MyRunnableDiv()));

        Future<Integer> futureTask = service.submit(new MyCallableInc());

        System.out.println(futureTask.get());
        System.out.println(Data.x);

        service.shutdown();
    }
}

class Data {

    static AtomicInteger x = new AtomicInteger(0);
    static Integer y = 0;

    public static synchronized void setY() {
        y++;
    }

    public static int getY() {
        synchronized (y) {
            return y;
        }
    }
}

class MyCallableInc implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 50; i++) {
            Data.setY();
        }

        return Data.getY();
    }
}

class MyRunnableInc implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Data.x.incrementAndGet();
        }
    }
}

class MyRunnableDiv implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Data.x.decrementAndGet();
        }
    }
}