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

//    public int minPartitions(String n) {
////        String res = "";
////        while (!res.equals(n)) {
////
////        }
//    }

    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(max, Integer.parseInt(Character.toString(n.charAt(i))));
        }

        return max;
    }

    public String maximumTime(String time) {
        String result = "";
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == '?') {
                if (i == 0) {
                    if (time.charAt(1) == '?') {
                        result = result.concat("2");
                    } else if (time.charAt(1) >= '4') {
                        result = result.concat("1");
                    } else if (time.charAt(1) < '4') {
                        result = result.concat("2");
                    }
                } else if (i == 1) {
                    if (result.charAt(0) == '2') {
                        result = result.concat("3");
                    } else if (result.charAt(0) <= '1') {
                        result = result.concat("9");
                    }
                } else if (i == 3) {
                    result = result.concat("5");
                } else if (i == 4) {
                    result = result.concat("9");
                }
            } else {
                result = result.concat(String.valueOf(time.charAt(i)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTime("??:3?"));
    }
}
