package ru.ivanovds.yandex.stagirovka;

import java.util.*;
import java.util.stream.Collectors;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // кол-во скульптур
        int X = scanner.nextInt(); // кол-во льда в скульптурах
        int T = scanner.nextInt(); // оставшеяся время
        scanner.nextLine();

        Map<Integer, Integer> array = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            array.put(i, num);
        }
        scanner.close();
        Map<Integer, Integer> map = array.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        int time = T;
        List<Integer> result = new ArrayList<>();

//        for (int i = 0; i < map.size(); i++) {
//            int res = time - Math.abs(X - map.get(i));
//            System.out.print(res);
//            if (res <= 0) {
//                continue;
//            }
//            time -= res;
//            result.add(i + 1);
//        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int res = time - Math.abs(X - entry.getValue());
            if (res <= 0) {
                continue;
            }
            time -= res;
            result.add(entry.getKey() + 1);
        }

        System.out.println(result.size());
        result.forEach(it -> System.out.print(it + " "));
    }
}
