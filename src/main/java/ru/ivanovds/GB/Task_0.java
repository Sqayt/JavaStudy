package ru.ivanovds.GB;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_0 {
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Task_0 task0 = new Task_0();
        String jewels = task0.input();
        String stones = task0.input();
        String result = task0.findJewelsInStones(jewels, stones);

        System.out.println(result);
    }

    private String input() {
        while (true) {
            if (scan.hasNextLine()) {
                return scan.nextLine();
            } else {
                System.out.println("Ошибка, введите строку еще раз");
            }
        }
    }

    public String findJewelsInStones(String jewels, String stones) {
        char[] arrayJewels = jewels.toCharArray();
        char[] arrayStones = stones.toCharArray();

        Set<Character> setJewels = new HashSet<>();
        for (char arrayJewel : arrayJewels) {
            setJewels.add(arrayJewel);
        }

        Map<Character, Integer> map = new HashMap<>();

        for (Character symb: setJewels) {
            for (Character jym: arrayStones) {
                if (symb == jym) {
                    map.put(symb, value(map.get(symb)));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            result.append(entry.getKey().toString()).append(entry.getValue());
        }

        return result.toString();
    }

    public static int value(Integer x) {
        if (x == null) {
            return 1;
        } else {
            return ++x;
        }
    }
}
