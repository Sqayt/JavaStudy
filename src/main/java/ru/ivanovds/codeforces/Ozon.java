package ru.ivanovds.codeforces;

import java.util.*;

public class Ozon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            int size = scanner.nextInt();
            int[] array = developsArray(size, scanner);
            print(array);
            System.out.println();
        }
    }

    public static int[] developsArray(int size, Scanner scanner) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            int elem = scanner.nextInt();
            array[i] = elem;
        }

        return array;
    }

    public static void print(int[] array) {
        boolean isWork = true;
        while (isWork) {
            isWork = false;
            for (int i = 0; i < array.length; i++) {
                int currentElem = array[i];

                if (!isWork) {
                    for (int j = 0; j < array.length; j++) {
                        if (currentElem == array[j] && i != j && array[j] > -1 && currentElem > -1) {
                            System.out.println((i + 1) + " " + (j + 1));
                            array[i] = -1;
                            array[j] = -1;

                            isWork = true;
                            break;
                        }
                    }
                }

                if (!isWork) {
                    for (int j = 0; j < array.length; j++) {
                        if ((currentElem == array[j] - 1 || currentElem == array[j] + 1) && i != j && array[j] > -1
                                && currentElem > -1) {
                            System.out.println((i + 1) + " " + (j + 1));
                            array[i] = -1;
                            array[j] = -1;

                            isWork = true;
                            break;
                        }
                    }
                }
            }
        }
    }
}
