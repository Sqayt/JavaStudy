package ru.ivanovds;

import java.util.Random;

public class MainApp {

    public MainApp() {
    }

    public static void main(String[] args) {
        int[] array = fillArray(10, 0, 100);
        printArray(array);

        quickSort(array, 0, 9);
        printArray(array);
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    private static int[] fillArray(int size, int origin, int bound) {
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(origin, bound);
        }

        return array;
    }

    private static void printArray(int[] array) {
        for (Integer el: array) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
