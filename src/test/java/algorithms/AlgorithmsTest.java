package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ivanovds.algorithms.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmsTest {

    Algorithms algorithms = new Algorithms();
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void linearSearchTest() {
        int num = algorithms.linearSearch(arr, 5);
        Assertions.assertEquals(num, 4);
        algorithms.print(5, 4);
    }

    @Test
    public void binarySearchIterationTest() {
        int num = algorithms.binarySearchIteration(arr, 5);
        Assertions.assertEquals(num, 4);
        algorithms.print(5, 4);
    }

    @Test
    public void binarySearchRecursionTest() {
        int num = algorithms.binarySearchRecursion(arr, arr[0], arr[arr.length - 1], 5);
        Assertions.assertEquals(num, 4);
        algorithms.print(5, 4);
    }

    @Test
    public void performKMPSearchTest() {
        String pattern = "AAABAAA";
        String text = "ASBNSAAAAAABAAAAABAAAAAGAHUHDJKDDKSHAAJF";

        List<Integer> foundIndexes = algorithms.performKMPSearch(text, pattern);
        List<Integer> testIndexes = new ArrayList<>();

        testIndexes.add(8);
        testIndexes.add(14);

        Assertions.assertEquals(foundIndexes, testIndexes);
        algorithms.print(foundIndexes);
    }
}
