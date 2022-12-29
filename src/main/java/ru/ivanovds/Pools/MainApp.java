package ru.ivanovds.Pools;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        MainApp app = new MainApp();
//        double result = app.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
//        System.out.println(result);
        List<Parent> parentList = new ArrayList<>();
        List<Child> children = new ArrayList<>();
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//
//        if (m > n)
//            return findMedianSortedArrays(nums2, nums1);
//
//        int i = 0, j = 0, iMin = 0, iMax = m, half = (m + n + 1) / 2;
//        double maxLeft = 0, minRight = 0;
//
//        while (iMin <= iMax) {
//
//        }
//
//    }

    public void m(List<Parent> e) {

    }


    public String convert(String s, int numRows) {
        String[] words = s.split("");
        for(int i = 0; i < words.length; i++) {

            for(int j = 0; j < words.length; j++) {

            }
        }

        return "";
    }
}

class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1 -> {
                big -= 1;

                return big >= 0;
            }
            case 2 -> {
                medium -= 1;

                return medium >= 0;
            }
            case 3 -> {
                small -= 1;

                return small >= 0;
            }
            default -> {
                System.out.println("Неизвестный тип машиный");
                return false;
            }
        }
    }
}

class Parent {

}

class Child extends Parent {

}
