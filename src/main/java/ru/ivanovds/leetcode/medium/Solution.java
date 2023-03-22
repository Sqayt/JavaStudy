package ru.ivanovds.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        if (n < 2) {
            return Stream.of("()").toList();
        }
        List<String> result = new ArrayList<>();
        dfs(result, "", n, 0);

        return result;
    }

    List<List<Integer>> master = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> rest = new ArrayList<>();
        for (int i : nums) {
            rest.add(i);
        }
        List<Integer> list = new ArrayList<>();
        permute(rest, list);
        return master;
    }

    private void permute(List<Integer> rest, List<Integer> list) {
        if (rest.isEmpty()) {
            List<Integer> copy = new ArrayList<>(list);
            master.add(copy);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            Integer curr = rest.get(i);
            rest.remove(i);
            list.add(curr);
            permute(rest, list);
            rest.add(i, curr);
            list.remove(list.size() - 1);
        }
    }

    public void dfs(List<String> res, String s, int n, int count) {
        if (n == 0 && count == 0) {
            res.add(s);
        }
        if (n < 0 || count < 0) {
            return;
        }

        dfs(res, s + "(", n - 1, count + 1);
        dfs(res, s + ")", n, count - 1);
    }
}
