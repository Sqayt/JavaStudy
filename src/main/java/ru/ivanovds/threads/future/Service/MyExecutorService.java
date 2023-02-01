package ru.ivanovds.threads.future.Service;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MyExecutorService {

    private ExecutorService service = Executors.newFixedThreadPool(10);

    public void executorService() throws InterruptedException, ExecutionException {
        Runnable runnable = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
            System.out.println(Thread.currentThread().getName().concat(" It is runnable"));
        };

        Callable<String> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return Thread.currentThread().getName().concat(" It is callable");
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        Map<Integer, Callable<String>> callableMap = new HashMap<>();

        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);

        callableMap.put(0, callable);
        callableMap.put(1, callable);
        callableMap.put(2, callable);

        List<Callable<String>> callableList = new ArrayList<>(callableMap.values());

        service.execute(runnable);
        Future<String> future = service.submit(callable);
        String result = service.invokeAny(callableTasks);
        List<Future<String>> futures = service.invokeAll(callableTasks);

        String resultMap = service.invokeAny(callableList);
        List<Future<String>> futureMap = service.invokeAll(callableList);

        String sb = future.get() + "\n" +
                result + "\n";

        System.out.println(sb);
        futures.forEach(
                it -> {
                    try {
                        System.out.println(it.get() + " ");
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace(System.out);
                    }
                }
        );
    }

    public void shutdownService() {
        service.shutdown();
    }

    public void myExecutor() {
        Executor executor = new anExecutor();
        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        });
    }
}

class anExecutor implements Executor {

    @Override
    public void execute(@NotNull Runnable command) {
        command.run();
    }
}
