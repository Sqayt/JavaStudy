package ru.ivanovds.GB.Lesson4HM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task_3 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println(new Task_3().checkOn(deque) ? "It is palindrome" : "It is not palindrome");
    }

    public boolean checkOn(Deque<Integer> deque) {
        boolean isPalindrome = true;

//        while ()

        return isPalindrome;
    }
}
