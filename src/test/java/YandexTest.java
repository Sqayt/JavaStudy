import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ivanovds.yandex.TaskA;

@ExtendWith(MockitoExtension.class)
public class YandexTest {

    @Mock
    TaskA taskA = new TaskA();

    @Test
    public void taskATest() {
        System.out.println(taskA.equation(1, 1, 2, 2));
    }
}
