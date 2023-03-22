package ru.ivanovds.yandex.algorithm3;

import java.util.*;

public class TaskA {
    public static void task2(int k, String text) {
        String[] textArray = text.split("");
        List<Integer> lst = new ArrayList<>();
        for (String s : textArray) {
            lst.add(Character.getNumericValue(s.charAt(0)));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lst.size(); i++) {
            int max = 0;
            int z = k;
            for (int j = 0; j < lst.size(); j++) {
                z--;
                if (i != j && lst.get(i).equals(lst.get(j))) {
                    max++;
                }

                if (z <= 0) {
                    break;
                }
            }
            System.out.println(max + " " + k);
            set.add(max + (z + 2));
        }

        set.stream().forEach(it -> System.out.print(it + " "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String text = scanner.next();

        task2(k, text);
    }
}
