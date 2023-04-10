package ru.ivanovds.GB.Lesson3HM;

import java.util.Random;

public class Task_1 {

    public static void main(String[] args) {
        int[] data = new int[10000];
        for (int i = 0; i < 10000; i++) {
            data[i] = new Random().nextInt(10000000);
        }
        System.out.print("Не отсортированный массив: ");
        new Task_1().print(data);

        long startTime = System.currentTimeMillis();
//        new Task_1().mergeSort(data, data.length);
        new Task_1().selectionSort(data);
        long finishTime = (System.currentTimeMillis() - startTime);

        System.out.print("Отсортированный массив: ");
        new Task_1().print(data);

//        System.out.println("Время выполнения цикла mergeSort (Сортировка слиянием): " + finishTime + " мс");
        System.out.println("Время выполнения цикла selectionSort (Сортировка выбором): " + finishTime + " мс");

    }

    /*
        Алгоритм сортировки выборкой.
        Время выполнения (Big O) = O(n^2)
        Очень долгий алгоритм, как и сортировка пузырьком
     */
    public void selectionSort(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    /*
        Алгоритм сортировки слиянием.
        Время выполнения (Big O) = O(log n (2))
        Один из самых быстрых алгоритмов сортировки
    */
    public void mergeSort(int[] array, int size) {
        if (size < 2) {
            return;
        }

        int mid = size / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < size; i++) {
            rightArray[i - mid] = array[i];
        }

        mergeSort(leftArray, mid);
        mergeSort(rightArray, size - mid);

        merge(array, leftArray, rightArray, mid, size - mid);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[i]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < left) {
            array[k++] = leftArray[i++];
        }

        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }

    private void print(int[] array) {
        for (Integer elem :
                array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
