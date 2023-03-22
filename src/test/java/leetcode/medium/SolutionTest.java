package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ivanovds.leetcode.medium.Solution;

import java.util.List;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void generateParenthesisTest() {
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }

}
