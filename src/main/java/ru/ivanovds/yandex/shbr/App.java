package ru.ivanovds.yandex.shbr;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        if (!isValid(n) || !isValid(n, m)) {
            return;
        }
        scanner.nextLine();

        Map<Integer, List<Integer>> map = fillMap(n, m);

        for (int i = 0; i < q; i++) {
            String[] words = scanner.nextLine().split(" ");

            String cmd = words[0];
            int currentData = 0;
            int currentServ = 0;

            if (words.length >= 2) {
                currentData = Integer.parseInt(words[1]);
            } if (words.length >= 3) {
                currentServ = Integer.parseInt(words[2]);
            }

            switch (cmd) {
                case "RESET" -> {
                    reset(map, currentData);
                }
                case "DISABLE" -> {
                    disable(map, currentData, currentServ);
                }
                case "GETMAX" -> {
                    getMax(map);
                }
                case "GETMIN" -> {
                    getMin(map);
                }

                default -> System.out.println("ERROR");
            }

            scanner.nextLine();
        }

        scanner.close();
    }

    private static void reset(Map<Integer, List<Integer>> map, int currentData) {
        List<Integer> lst = map.get(currentData);

        for (int i = 0; i < lst.size(); i++) {
            lst.set(i, i);
        }

        map.put(currentData, lst);
    }

    private static void disable(Map<Integer, List<Integer>> map, int currentData, int currentServ) {
        List<Integer> lst = map.get(currentData);

        lst.set(currentServ - 1, -1);
    }

    private static void getMax(Map<Integer, List<Integer>> map) {
        int max = 0;
        int index = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                index = entry.getKey();
            }
        }

        System.out.println(index);
    }

    private static void getMin(Map<Integer, List<Integer>> map) {
        int min = map.get(map.size() - 1).size();
        int index = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() < min) {
                min = entry.getValue().size();
                index = entry.getKey();
            }
        }

        System.out.println(index);
    }

    public static boolean isValid(int numb) {
        return numb >= 1 && numb <= Math.pow(10, 5);
    }

    public static boolean isValid(int n, int m) {
        return n * m >= 1 && n * m <= Math.pow(10, 6);
    }

    private static Map<Integer, List<Integer>> fillMap(int n, int m) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> lst = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                lst.add(j, j + 1);
            }

            map.put(i + 1, lst);
        }

        return map;
    }
}
