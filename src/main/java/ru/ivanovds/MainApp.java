package ru.ivanovds;

import java.util.Scanner;

public class MainApp {

    public MainApp() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double disk = Math.pow(b,2) - (4 * a * c);
        if (disk == 0) {
            double x = (double) (-b) / (2 * a);
            System.out.println(x);
        } else if (disk > 0) {
            double x1 = (-b + Math.sqrt(disk)) / (2 * a);
            double x2 = (-b - Math.sqrt(disk)) / (2 * a);
            if (x1 < x2) {
                System.out.println(x1 + " " + x2);
            } else {
                System.out.println(x1 + " " + x2);
            }
        }
    }
}
