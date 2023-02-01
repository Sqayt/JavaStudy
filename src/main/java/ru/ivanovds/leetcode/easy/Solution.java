package ru.ivanovds.leetcode.easy;

import java.util.*;

public class Solution {

    public int findFinalValue(int[] nums, int original) {
        boolean isFound = false;

        while(!isFound) {
            isFound = true;
            for (Integer num: nums) {
                if (original == num) {
                    original *= 2;
                    isFound = false;
                    break;
                }
            }
        }

        return original;
    }

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String value : words) {
            String word;
            if (value.length() > s.length()) {
                word = s;
            } else {
                word = String.valueOf(s.subSequence(0, value.length()));
            }

            if (word.equals(value)) {
                count++;
            }
        }

        return count;
    }

    public int removePalindromeSub(String s) {
        return 0;
    }

    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int differenceOfSum(int[] nums) {
        int esum = 0, dsum = 0;
        for (int i : nums) {
            esum += i;
            for (int j = i; j > 0; j/= 10)
                dsum += (j % 10);
        }
        return Math.abs(dsum-esum);

    }

    public String interpret(String command) {
        if(command.isBlank() || command.length()==1){
            return command;
        }

        StringBuilder sb = new StringBuilder();
        int length = command.length();
        for(int i= 0; i < length; i++){
            char c = command.charAt(i);
            if(c =='G'){
                sb.append('G');
            }else if(c=='(' && i<length-1&& command.charAt(i+1)==')'){
                sb.append("o");
                i++;
            }else{
                sb.append("al");
                i+=3;
            }
        }
        return sb.toString();
    }

//    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//
//    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
