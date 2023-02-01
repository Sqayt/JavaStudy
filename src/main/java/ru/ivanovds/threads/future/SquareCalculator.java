package ru.ivanovds.threads.future;

import java.util.concurrent.*;

public class SquareCalculator {

    private ExecutorService service = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return service.submit(() -> {
            Thread.sleep(1_000);
            return input * input;
        });
    }

    public void shutdownService() {
        service.shutdown();
    }
}

class FT implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int j = 0;

        for (int i = 0; i < 10; i++, j++) {
            Thread.sleep(300);
        }

        return j;
    }
}
