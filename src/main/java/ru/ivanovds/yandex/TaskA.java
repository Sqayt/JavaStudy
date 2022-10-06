package ru.ivanovds.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskA {

    public TaskA() {
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 0;

        if (scanner.hasNext() && scanner.hasNextInt()) {
            num = scanner.nextInt();
            scanner.nextLine();
        }

        String[] lines = new String[num];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = scanner.nextLine();
        }

        scanner.close();

//        String[] lines = {"Volozh,Arcady,Yurievich,11,2,1964", "Segalovich,Ilya,Valentinovich,13,9,1964"};
        List<String> result = new ArrayList<>();

        for (String s : lines) {
            List<String> line = Arrays.stream(s.split(""))
                    .filter(word -> !word.equals(","))
                    .collect(Collectors.toList());

            int numbDate = line.stream()
                    .filter(TaskA::isNumeric)
                    .limit(3)
                    .mapToInt(Integer::parseInt)
                    .sum();

            long numb = line.stream()
                    .filter(word -> !isNumeric(word))
                    .distinct()
                    .count();

            int position = line.stream()
                    .findFirst()
                    .map(x -> changeWord(x.charAt(0)))
                    .orElseThrow();

            String res = hexTo16((int) (numb + (64 * numbDate) + (256 * position)));
            result.add(res);
        }

        result.forEach(str -> System.out.print(str + " "));
    }

    private static boolean isNumeric(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int changeWord(char word) {
        char smalla = 'a';
        return (int) Character.toLowerCase(word) - (int) smalla + 1;
    }

    private static String hexTo16(int numb) {
        String result = Integer.toHexString(numb);
        String[] resultArray = result.split("");

        StringBuilder res = new StringBuilder();

        for (int i = 1; i < resultArray.length; i++)
            res.append(resultArray[i]);

        return res.toString();
    }
}
