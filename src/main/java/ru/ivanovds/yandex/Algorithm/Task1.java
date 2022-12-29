package ru.ivanovds.yandex.Algorithm;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(h * 60 + m);
    }
}
