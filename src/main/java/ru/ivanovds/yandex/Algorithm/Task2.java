package ru.ivanovds.yandex.Algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Task2 {

    /*
        Do not use, O(n^2)
     */
    public static int[] find(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] + array[j] == x) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[] {0, 0};
    }

    /*
        It is correct, O(n)
     */
    public static int[] findSet(Integer[] array, int x) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer integer : array) {
            Integer res = x - integer;
            if (hashSet.contains(res)) {
                return new int[] {integer, res};
            }
            hashSet.add(integer);
        }

        return new int[] {0, 0};
    }


    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 8, 2};
        System.out.println(Arrays.toString(findSet(array, 5)));
    }
}
