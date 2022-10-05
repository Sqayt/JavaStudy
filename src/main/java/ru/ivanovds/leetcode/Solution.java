package ru.ivanovds.leetcode;

import java.util.*;

public class Solution {

    public Solution() {

    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    public String addStrings(String num1, String num2) {
        if(num1==null || num1.isEmpty()){
            return num2;
        }
        if(num2==null || num2.isEmpty()){
            return num1;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        int c1;
        int c2;
        StringBuilder answer = new StringBuilder();
        while(len1>0 || len2>0 || carry > 0){
            c1 = len1-- > 0 ? num1.charAt(len1) - '0': 0;
            c2 = len2-- > 0 ? num2.charAt(len2) - '0': 0;
            int sum = carry + c1 + c2;
            carry = sum/10;
            answer.insert(0, sum % 10);
        }

        return answer.toString();
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for(int n: nums)
            if( (n&1) == 0){
                Integer value = table.get(n);
                value = (value == null) ? 1 : value + 1;
                table.put(n, value);
            }

        int ans = -1, frec = 0;
        for(Map.Entry<Integer, Integer> it : table.entrySet())
            if(it.getValue() > frec || (it.getValue() == frec && ans > it.getKey() ))
            {frec = it.getValue(); ans = it.getKey();}

        return ans;
    }
}
