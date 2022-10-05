package ru.ivanovds;

import java.util.Scanner;

public class MainApp {

    public MainApp() {
    }

    public static void main(String[] args) {
    }

    public void kislota_var1_yandex() {
        Scanner scanner = new Scanner(System.in);

        int a = 0;
        int b = 0;
        int c = 0;

        if (scanner.hasNext() && scanner.hasNextInt()) {
            a = scanner.nextInt();
        }

        scanner.nextLine();

        if (scanner.hasNext() && scanner.hasNextInt()) {
            b = scanner.nextInt();
            c = scanner.nextInt();
        }

        System.out.println(a + " " + b + " " + c);
    }
}
