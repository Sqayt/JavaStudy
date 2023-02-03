package ru.ivanovds.yandex.workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    public static Scanner scanner = new Scanner(System.in);

    private int inputRows(Scanner scanner) {
        return scanner.nextInt();
    }

    private String inputRow(Scanner scanner) {
        return scanner.nextLine();
    }

    private List<String> getPlaces() {
        int size = inputRows(scanner);
        scanner.nextLine();
        List<String> places = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            places.add(inputRow(scanner));
        }

        return places;
    }

    private List<String> getDesirePeople() {
        int size = inputRows(scanner);

        ArrayList<String> lst = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lst.add(inputRow(scanner));
        }

        return lst;
    }

    private void shutScan(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();

        List<String> places = task2.getPlaces();
        List<String> people = task2.getDesirePeople();

        places.stream().forEach(System.out::println);
        people.stream().forEach(System.out::println);
        task2.shutScan(scanner);
    }
}
