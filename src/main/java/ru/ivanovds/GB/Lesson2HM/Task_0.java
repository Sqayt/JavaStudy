package ru.ivanovds.GB.Lesson2HM;

import java.util.*;

public class Task_0 {
    private final static Scanner scan = new Scanner(System.in);

    private static String input() {
        while (true) {
            if (scan.hasNextLine()) {
                return scan.nextLine();
            } else {
                System.out.println("Ошибка, введите строку еще раз");
            }
        }
    }

    public static String findJewelsInStones(String jewels, String stones) {
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

    public static void main(String[] args) {
        String jewels = input();
        String stones = input();
        String result = findJewelsInStones(jewels, stones);
        System.out.println(result);

//        Test
//        System.out.println(findJewelsInStones("aB", "aaaAbbbB").equals("a3B1")
//                ? "Test is complete" : "Test is not complete");
    }
}
