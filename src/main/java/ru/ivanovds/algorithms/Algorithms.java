package ru.ivanovds.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algorithms {

    /*
        Сложность алгоритма - O(N)
     */
    public int linearSearch(int[] arr, int elemToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elemToSearch) {
                return i;
            }
        }

        return -1;
    }

    /*
        !Только отсортированный список!
        Сложность алгоритма - О(log (N))
     */
    public int binarySearchIteration(int[] arr, int elemToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == elemToSearch) {
                return middleIndex;
            }

            else if (arr[middleIndex] < elemToSearch) {
                firstIndex = middleIndex + 1;
            }

            else if (arr[middleIndex] > elemToSearch) {
                lastIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    /*
        !Только отсортированный список!
        Сложность алгоритма - О(log (N))
     */
    public int binarySearchRecursion(int[] arr, int firstElem, int lastElem,  int elemToFound) {
        if (firstElem <= lastElem) {
            int mid = firstElem + (lastElem - firstElem) / 2;

            if (arr[mid] == elemToFound) {
                return mid;
            }

            if (arr[mid] > elemToFound) {
                return binarySearchRecursion(arr, firstElem, mid - 1, elemToFound);
            }
            else if (arr[mid] < elemToFound) {
                return binarySearchRecursion(arr, mid + 1, lastElem, elemToFound);
            }
        }

        return -1;
    }

    private int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] compliedPatternArray = new int[patternLength];

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compliedPatternArray[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = compliedPatternArray[len - 1];
                } else {
                    compliedPatternArray[i] = len;
                    i++;
                }
            }
        }
        System.out.println("Compiled Pattern Array " + Arrays.toString(compliedPatternArray));

        return compliedPatternArray;
    }

    /*
        Алгоритм КМП осуществляет поиск текста по заданному шаблону.

        В этом поиске сначала компилируется заданный шаблон. Компилируя шаблон, мы пытаемся найти префикс и суффикс
        строки шаблона. Это поможет в случае несоответствия – не придётся искать следующее совпадение
        с начального индекса. Вместо этого мы пропускаем часть текстовой строки, которую уже сравнили, и начинаем
        сравнивать следующую. Необходимая часть определяется по префиксу и суффиксу, поэтому известно, какая часть
        уже прошла проверку и может быть безопасно пропущена.

        КМП работает быстрее алгоритма перебора благодаря пропускам.

        Сложность алгоритма - O(n)
     */

    public List<Integer> performKMPSearch(String text, String pattern) {
        int[] compliedPatternArray = compilePatternArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        List<Integer> foundIndexes = new ArrayList<>();
        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            } if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            } else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0) {
                    patternIndex = compliedPatternArray[patternIndex - 1];
                } else {
                    textIndex = textIndex + 1;
                }
            }
        }

        return foundIndexes;
    }

    public void print(int elemToSearch, int index) {
        if (index == -1) {
            System.out.println("Elem " + elemToSearch + " is not found");
        } else {
            System.out.println("Elem " + elemToSearch + " found to index:" + index);
        }
    }

    public void print(List<Integer> lst) {
        if (lst == null || lst.isEmpty()) {
            System.out.println("Pattern not found in the given text String");
        } else {
            System.out.println("Pattern found in the given text String at positions: " + lst.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
    }
}
