package ru.ivanovds.yandex.codeRun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] table = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            int[] num = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (size[1] >= 0) System.arraycopy(num, 0, table[i], 0, size[1]);
        }

        for (int[] array: table) {
            for (int nums: array) {
                System.out.print(nums + " ");
            }
            System.out.println();
        }

        reader.close();
        writer.close();
    }



    private static void carnations(BufferedReader reader) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] arrayA = new int[N];
        int[] arrayVS = new int[N];
        String[] result = reader.readLine().split(" ");
        for (int i = 0; i < result.length; i++) {
            arrayA[i] = Integer.parseInt(result[i]);
        }

        for (int i = 0; i < result.length; i++) {
            arrayVS[i] = 0;
        }

        Arrays.sort(arrayA);
        int ans;
        if (N == 2) {
            ans = Math.abs(arrayA[1] - arrayA[0]);
        } else {
            arrayVS[1] = arrayA[1] - arrayA[0];
            arrayVS[2] = arrayA[2] - arrayA[0];
            for (int i = 3; i < N; i++) {
                arrayVS[i] = Math.min(arrayVS[i - 1], arrayVS[i - 2]) + arrayA[i] - arrayA[i - 1];
            }

            ans = arrayVS[arrayVS.length - 1];
        }

        System.out.println(ans);
    }
}
