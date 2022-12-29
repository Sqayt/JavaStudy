package ru.ivanovds.yandex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<String[]> place = createList(scanner, n, "place");


        int m = scanner.nextInt();
        scanner.nextLine();

        if (m < 0 || m > 100) {
            return;
        }

        List<String[]> groups = createList(scanner, m, "groups");
    }


    private static List<String[]> createList(Scanner scanner, int size, String type) {
        if (scanner == null || type == null) {
            return new ArrayList<>();
        }
        List<String[]> place = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            String tmp = scanner.nextLine();
            if (type.equals("place")) {
                String[] tmpArray = tmp.split("");
                place.add(tmpArray);
            } else if (type.equals("groups")) {
                String[] tmpArray = tmp.split(" ");
                place.add(tmpArray);
            } else {
                System.out.println("Incorrect type");
            }
        }

        return place;
    }

    private static void print(List<String[]> lst) {
        System.out.println();
        if (lst != null)
            lst.forEach(
                    it -> {
                        for (String str: it) {
                            System.out.print(str + " ");
                        }
                        System.out.println();
                    }
            );
    }
}
