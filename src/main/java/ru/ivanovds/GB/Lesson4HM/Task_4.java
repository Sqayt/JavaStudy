package ru.ivanovds.GB.Lesson4HM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task_4 {

    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
        Deque<Integer> result = new Task_4().sum(d1, d2);
        result
                .forEach(System.out::println);
    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (d1.iterator().hasNext() && d2.iterator().hasNext()) {
            int sum = d1.pop() + d2.pop();
            deque.push(sum);
        }

        return deque;
    }
}
