package ru.ivanovds.Collections;

import java.util.*;

public class MyHashMap {
    public static void main(String[] args) {
        Map<String, String> book = new HashMap<>();
        Map<Integer, String> menu = new TreeMap<>();
        Map<String, Boolean> people = new Hashtable<>();
        Map<String, Integer> cities = new LinkedHashMap<>();
        Map<Integer, Integer> price = new WeakHashMap<>();
    }
}
