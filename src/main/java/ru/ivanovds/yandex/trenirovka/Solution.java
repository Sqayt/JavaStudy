package ru.ivanovds.yandex.trenirovka;

import java.util.*;

public class Solution {

    public void taskA() {
        Scanner scanner = new Scanner(System.in);

        int countKeys = scanner.nextInt();
        scanner.nextLine();

        List<Integer> lstOne = fillArray(countKeys, scanner);

        List<Integer> lstTwo = fillArray(countKeys, scanner);

        int countSymbol = scanner.nextInt();
        scanner.nextLine();

        List<Integer> lstThree = fillArray(countSymbol, scanner);

        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < countKeys; i++) {
            maps.put(lstOne.get(i), lstTwo.get(i));
        }
        maps.forEach((key, value) -> System.out.println(key + " " + value));

        scanner.close();


    }

    private List<Integer> fillArray(int size, Scanner scanner) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int numb = scanner.nextInt();
            lst.add(numb);
        }

        scanner.nextLine();
        return lst;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.taskA();
    }
}
