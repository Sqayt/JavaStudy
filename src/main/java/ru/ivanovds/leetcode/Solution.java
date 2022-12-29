package ru.ivanovds.leetcode;

import ru.ivanovds.MainApp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int myAtoi(String s) {
        char[] array = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < array.length; i++) {
            if (array[i] != ' ') {
                if (Character.isDigit(array[i])) {
                    result.append(array[i]);
                }
                if (i != 0 && !Character.isDigit(array[i - 1])) {
                    if (array[i] == '+' || array[i] == '-')
                        result.append(array[i]);
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    public String intToRoman(int num) {



        return "";
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            if (!isValidHorizontal(board[i])) {
                return false;
            }

            for(int j = 0; j < board[i].length; j++) {

            }
        }


        return false;
    }

    private boolean isValidHorizontal(char[] row) {
        Arrays.sort(row);
        Character prev = null;

        for(Character e: row) {
            if (e != null && e.equals(prev) && !e.equals('.')) {
                return false;
            }

            prev = e;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution app = new Solution();
        app.myAtoi("4193 with words");
    }
}
