package ru.ivanovds.yandex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public TaskB() {
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int num = 0;
//
//        if (scanner.hasNext() && scanner.hasNextInt()) {
//            num = scanner.nextInt();
//            scanner.nextLine();
//        }
//
//        String[] lines = new String[num];
//
//        for (int i = 0; i < lines.length; i++) {
//            lines[i] = scanner.nextLine();
//        }
//
//        scanner.close();

        String[] lines = {"50 7 25 3632 A", "14 23 52 212372 S",
        "15 0 5 3632 C", "14 21 30 212372 A", "50 7 26 3632 C",
        "14 21 30 3632 A", "14 21 40 212372 B", "14 23 52 3632 B"};


        while(true) {
            for (int i = 0; i < lines.length; i++) {
                String[] lnMain = lines[i].split(" ");

                for (int j = 0; j < lines.length; j++) {
                    if (i != j) {
                        String[] lnOrigin = lines[i].split(" ");

                        if (lnMain[3].equals(lnOrigin[3])) {
                            if (Integer.parseInt(lnMain[1]) < Integer.parseInt(lnOrigin[1])) {

                            }
                        }
                    }
                }
            }
        }
    }
}