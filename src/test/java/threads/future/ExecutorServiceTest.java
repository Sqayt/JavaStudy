package threads.future;

import org.junit.jupiter.api.Test;
import ru.ivanovds.threads.future.Service.MyExecutorService;

import java.util.concurrent.ExecutionException;

public class ExecutorServiceTest {

    MyExecutorService executorService = new MyExecutorService();

    @Test()
    public void myExecutor() {
        try {
            executorService.executorService();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }
}
