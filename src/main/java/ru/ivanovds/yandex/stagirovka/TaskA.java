package ru.ivanovds.yandex.stagirovka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> array = new TaskA().twoRow(N, scanner);
    }

    public List<Integer> twoRow(int N, Scanner scanner) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            array.add(num);
        }

        return array;
    }

    public List<Integer> thirdRow(int N, Scanner scanner) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            array.add(num);
        }

        return array;
    }
}
