package ru.ivanovds.threads.data;

public class Resource {

    private volatile static int numb = 0;

    public static void incNumb() {
        numb++;
    }

    public static void decNumb() {
        numb--;
    }

    public static int getNumb() {
        return numb;
    }
}