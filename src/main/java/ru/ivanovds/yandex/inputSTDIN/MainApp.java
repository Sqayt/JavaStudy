package ru.ivanovds.yandex.inputSTDIN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
    }

    public void inputOracleJava7() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().trim();
        String[] strings = input.split(" ");
        System.out.println(Arrays.toString(strings));
    }

    public void inputOracleJava8() throws IOException {
        int x = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] took = word.split(" ");
        System.out.println(Arrays.toString(took));
    }

    public void inputJdkJava11() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            bf.close();
            String[] s2 = s.split(" ");
            System.out.println(Arrays.toString(s2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void myInputJdkJava11() throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String word = bf.readLine();
            String[] words = word.split(" ");
            System.out.println(Arrays.toString(words));
        }
    }
}
