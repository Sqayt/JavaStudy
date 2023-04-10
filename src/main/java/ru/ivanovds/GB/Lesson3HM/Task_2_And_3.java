package ru.ivanovds.GB.Lesson3HM;

import java.util.*;

public class Task_2_And_3 {

    public static void main(String[] args) {
        int[] data = new int[10000];
        for (int i = 0; i < 10000; i++) {
            data[i] = new Random().nextInt(10000000);
        }
        Task_2_And_3.print(data, "Исходный список:");
        long start = System.currentTimeMillis();
        int[] result = Task_2_And_3.task2(data);
        long finish = (System.currentTimeMillis() - start);
        Task_2_And_3.print(result, "Список без четных чисел:");
        System.out.println("Потраченное время: " + finish + " мс");
        Task_2_And_3.task3();
    }

    public static int[] task2(int[] array) {
        return Arrays.stream(array)
                .filter(it -> it % 2 != 0)
                .toArray();
    }

    public static void task3() {
        List<Integer> data = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            data.add(new Random().nextInt(10000000));
        }
        data.add(1); // минимальный элемент
        data.add(10000000 + 1); //  максимальный элемент


        IntSummaryStatistics statistics = data.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        Task_2_And_3.print(data, "Исходный массив");
        System.out.println("Минимальный элемент: " + statistics.getMin());
        System.out.println("Максимальный элемент: " + statistics.getMax());
        System.out.println("Средний элемент: " + statistics.getAverage());
    }

    private static void print(int[] array, String msg) {
        System.out.print(msg + " ");
        for (Integer elem :
                array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    private static void print(List<Integer> array, String msg) {
        System.out.print(msg + " ");
        for (Integer elem :
                array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
