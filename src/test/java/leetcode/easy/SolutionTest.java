package leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ivanovds.leetcode.easy.Solution;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void findFinalValueTest() {
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;

        Assertions.assertEquals(solution.findFinalValue(nums, original), 24);
    }

    @Test
    public void countPrefixesTest() {
        String[] words = {"e","s","mi","e","ia","ibwu","e","e","k","ci","rip","suw","a","l"};
        String s = "e";

        Assertions.assertEquals(solution.countPrefixes(words, s), 3);
    }

    @Test
    public void sumOfUnique() {
        int[] nums = {1, 2, 3, 2};

        Assertions.assertEquals(solution.sumOfUnique(nums), 4);
    }
}
