package ru.ivanovds.algorithms.book;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class MyBinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static boolean palindrom(String text) {
        int size = text.length() - 1;
        text = text.toLowerCase();
        for (int i = 0; i < size; i++) {
            if (text.charAt(i) != text.charAt(size - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        System.out.println(palindrom("Маша"));
    }
}
