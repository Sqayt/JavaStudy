package ru.ivanovds.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariay");
        arrayList1.add(7);
        arrayList1.add(true);

        arrayList1.forEach(el -> System.out.print(el + " "));
        System.out.println();

//        List<String> arrayList2 = new ArrayList<>(200);

        List<Boolean> arrayList3 = new ArrayList(arrayList1);
//        Stream.of(arrayList3)
//                .forEach(el -> System.out.print(el + " "));

        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }

        System.out.println(arrayList3.get(4).getClass());
    }
}
