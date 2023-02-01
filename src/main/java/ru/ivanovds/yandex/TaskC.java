package ru.ivanovds.yandex;

import java.util.Scanner;

public class TaskC {
    private int n;
    private int k;
    private int[] array;
    Scanner scanner = new Scanner(System.in);

    public void inputNumbers() {
        n = scanner.nextInt();
        k = scanner.nextInt();
    }

    public void inputArray() {
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

    }

}
