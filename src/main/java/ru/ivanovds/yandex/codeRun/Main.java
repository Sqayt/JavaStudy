package ru.ivanovds.yandex.codeRun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.close();
        writer.close();
    }

    private static void uniqueWords(BufferedReader reader) throws IOException {
        Set<String> result = new HashSet<>();

        String word;
        while (((word = reader.readLine()) != null) && (!word.equals(""))) {
            String[] newWords = word.split(" ");
            result.addAll(Arrays.asList(newWords));
        }
        System.out.println(result.size());
    }

    /**
     *  Надо побольшу поизучать, пока не понятно
     *  Анализ алгоритма:
     *  Пусть dp[i][j] содержит количество способов, которыми можно добраться из левого верхнего угла – клетки
     *  с координатами (1, 1) в правый нижний угол – клетку с координатами (n, m). Изначально обнулим массив dp и
     *  положим dp[1][1] = 1.
     *
     *  Согласно ходам коня в клетку (i, j) можно попасть либо из (i – 1, j – 2), либо из (i – 2, j – 1). Следовательно
     *  dp[i][j] = dp[i – 1][j – 2] + dp[i – 2][j – 1]
     *
     * @param reader
     * @throws IOException
     */

    private static void chess(BufferedReader reader) throws IOException {
        String[] size = reader.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        int[][] chess = new int[N + 1][M + 1];
        chess[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= M; j++) {
                chess[i][j] = chess[i - 1][j - 2] + chess[i - 2][j - 1];
            }
        }

        System.out.println(chess[N][M]);
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
