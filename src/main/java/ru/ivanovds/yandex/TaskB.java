package ru.ivanovds.yandex;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        TaskB taskB = new TaskB();
        Scanner scanner = new Scanner(System.in);

        List<String> seatPlane = taskB.inputList(scanner);
        List<String> seatGroups = taskB.inputList(scanner);

        taskB.print(seatPlane);
        taskB.print(seatGroups);
    }

    public List<String> inputList(Scanner scanner) {
        if (scanner == null) {
            return new ArrayList<>();
        }
        int row = scanner.nextInt();
        System.out.println(row);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            String line = scanner.nextLine();
            result.add(line);
        }
        scanner.next();

        return result;
    }

    public void print(@NotNull List<String> array) {
        if (array.isEmpty()) {
            System.out.println("Пустой массив");
            return;
        }
        array.stream().forEach(it -> System.out.print(it + " "));
    }
}
