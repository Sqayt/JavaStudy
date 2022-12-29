package ru.ivanovds.Collections;

import java.util.*;

public class ArrayListMethods1 {

    public static void main(String[] args) {

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lst.add(new Random().nextInt(0, 1000));
        }

        int[] array = lst.stream()
                        .mapToInt(it -> it)
                        .toArray();

//        sortBubbles(array);
        Arrays.sort(array);

        long timeStart = System.currentTimeMillis();
        int result = findIndexNumberOfArrayBinarySearch(array, 1);
        long time = System.currentTimeMillis() - timeStart;
        System.out.println("This is time: " + time + ", this is index:" + result);

//        Arrays.stream(array)
//                .forEach(it -> System.out.print(it + " "));

    }

    public Integer show(Integer arg) {
        return arg;
    }

    public static void sortBubbles(int[] array) {
        boolean isCheck = true;

        while (isCheck) {
            isCheck = false;

            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] < array[i + 1]) {
                    isCheck = true;
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }

    }


    public static int findIndexNumberOfArrayBinarySearch(int[] array, int value) {
        // Binary search O (log n)
        int low = 0;
        int index = -1;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                low = mid - 1;
            } else if (array[mid] == value) {
                index = mid;
                break;
            }
        }

        return index;
    }

    public static int findIndexNumberOfArraySimpleSearch(int[] array, int value) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
            }
        }

        return index;
    }
}
