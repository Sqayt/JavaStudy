package ru.ivanovds.yandex.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            String jewels = r.readLine();
            String stones = r.readLine();
            if (jewels.equals("") || stones.equals("")) {
                System.out.println(0);
                return;
            }

            Set<String> jewelsArray = Arrays.stream(jewels.split(""))
                    .collect(Collectors.toSet());
            String[] stonesArray = stones.split("");

            int count = 0;
            for (String value : jewelsArray) {
                for (String s : stonesArray) {
                    if (value.equals(s)) {
                        count++;
                    }
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
