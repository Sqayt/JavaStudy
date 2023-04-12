package ru.ivanovds.GB.Lesson6HM;

import ru.ivanovds.GB.Lesson6HM.models.Laptop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainApp {

    static Set<Laptop> laptopSet;


    public static void main(String[] args) {
        init();
        Map<Integer, String> dataFilter = askUser();
        List<Laptop> result = null;

        try {
            for (Map.Entry<Integer, String> entry : dataFilter.entrySet()) {
                switch (entry.getKey()) {
                    case 1 -> {
                        int ram = Integer.parseInt(entry.getValue());
                        result = laptopSet.stream().filter(it -> it.getRam() == ram).toList();
                    }
                    case 2 -> {
                        double ssd = Double.parseDouble(entry.getValue());
                        result = laptopSet.stream().filter(it -> it.getSizeHardDrive() == ssd).toList();
                    }
                    case 3 -> {
                        String os = entry.getValue();
                        result = laptopSet.stream().filter(it -> it.getOs().equals(os)).toList();
                    }
                    case 4 -> {
                        String color = entry.getValue();
                        result = laptopSet.stream().filter(it -> it.getColor().equals(color)).toList();
                    }
                    default -> System.out.println("Неизвестная функция, повторите еще раз");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильно введена функция или значение");
        }
        if (result != null && !result.isEmpty()) {
            System.out.println(result);
        }
    }

    public static void init() {
        laptopSet = new HashSet<>();
        laptopSet.add(new Laptop(0L, 2048, 512.12, "Windows", "Blue"));
        laptopSet.add(new Laptop(1L, 4096, 2000.00, "Linux", "Black"));
        laptopSet.add(new Laptop(2L, 1024, 252.00, "Mac OS", "Red"));
        laptopSet.add(new Laptop(3L, 8192, 4916.00, "Windows", "Green"));
        laptopSet.add(new Laptop(4L, 16384, 11175.00, "Windows", "Yellow"));
        laptopSet.add(new Laptop(5L, 1024, 300.00, "Linux", "White"));
    }

    public static Map<Integer, String> askUser() {
        Map<Integer, String> map = new HashMap<>();
        System.out.println("""
                Выберите функцию:
                1 - Сортировка по ОЗУ
                2 - Сортировка по SSD
                3 - Сортировка по OS
                4 - Сортировка по цвету
                """);
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            int fun = Integer.parseInt(r.readLine());
            System.out.println("Введите значение");
            String filter = r.readLine();
            map.put(fun, filter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }
}
