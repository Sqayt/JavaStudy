package ru.ivanovds.leetcode.courses;

import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader w = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(w.readLine());
            int b = Integer.parseInt(w.readLine());
            System.out.println(a + b);
            System.out.println(a * b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int maximumWealth(int[][] accounts) {
        int sumMax = 0;
        for (int[] bank : accounts) {
            int sumTmp = 0;
            for (Integer integer : bank) {
                sumTmp += integer;
            }

            sumMax = Math.max(sumTmp, sumMax);
        }

        return sumMax;
    }

    public String[] fizzBuzz(int n) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0 && (i + 1) % 5 != 0) result[i] = "Fizz";
            else if ((i + 1) % 5 == 0 && (i + 1) % 3 != 0) result[i] = "Buzz";
            else if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) result[i] = "FizzBuzz";
            else result[i] = String.valueOf(i + 1);
        }

        return result;
    }
}
