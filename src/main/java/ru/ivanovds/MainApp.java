package ru.ivanovds;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {

    public MainApp() {

    }

    /*
            [
                [],
                [],
                []
            ]
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainApp mainApp = new MainApp();

        int s = 0;
        int n = 0;
        int m = 0;

        try {
            s = scanner.nextInt();
            n = scanner.nextInt();
            m = scanner.nextInt();
        } catch (NumberFormatException ex) {
            System.err.println("Введите числа");
            return;
        } finally {
            scanner.nextLine();
        }

        String[][] array = new String[mainApp.maxNumb(s,n)][2];

        // Заполнение матрицы
        for (String[] value : array) {
            String[] num = scanner.nextLine().split(" ");
            if (mainApp.checkArray(num))
                System.arraycopy(num, 0, value, 0, value.length);
        }

        // Поиск значений
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length;) {
            for (int j = 0; j < array[i].length;) {
                if (sum < m) {
                    if (j == 0 && i == 0) {
                        sum += mainApp.checkNum(array[i][j]) ? Integer.parseInt(array[i][j]) : 0;
                    } if (j == 0) {
                        int tmpLeftUp = mainApp.checkNum(array[i + 1][j + 1]) ? Integer.parseInt(array[i + 1][j + 1]) : 0;
                        int tmpRightUp = mainApp.checkNum(array[i + 1][j]) ? Integer.parseInt(array[i + 1][j]) : 0;
                        int tmpRightMid = mainApp.checkNum(array[i][j + 1]) ? Integer.parseInt(array[i][j + 1]) : 0;

                        int tmp = Stream.of(tmpLeftUp,tmpRightUp,tmpRightMid)
                                .reduce(Math::min)
                                .get();

                        if (tmp == tmpLeftUp) { i = i + 1;}
                        else if (tmp == tmpRightUp) i = i + 1;
                        else if (tmp == tmpRightMid) j = j + 1;

                        sum += tmp;
                        count++;
                        System.out.println("i = " + i + " j = " + j + " array.length = " + array.length + " array[i].length = " + array[i].length );
                    } if (j == 1) {
                        int tmpLeftUp = mainApp.checkNum(array[i + 1][j - 1]) ? Integer.parseInt(array[i + 1][j - 1]) : 0;
                        int tmpRightUp = mainApp.checkNum(array[i + 1][j]) ? Integer.parseInt(array[i + 1][j]) : 0;
                        int tmpLeftMid = mainApp.checkNum(array[i][j - 1]) ? Integer.parseInt(array[i][j - 1]) : 0;

                        int tmp = Stream.of(tmpLeftUp,tmpRightUp,tmpLeftMid)
                                .reduce(Math::min)
                                .get();

                        if (tmp == tmpLeftUp) { i += 1; j -= 1; }
                        else if (tmp == tmpRightUp) i += 1;
                        else if (tmp == tmpLeftMid) j -= 1;

                        sum += tmp;
                        count++;
                        System.out.println("i = " + i + " j = " + j + " array.length = " + array.length + " array[i].length = " + array[i].length );
                    }
                }
            }
        }

        System.out.println("Sum = " + sum + " ,Count = " + count);

        scanner.close();

        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println("");
        }

    }

    public boolean checkArray(String[] numbs) {
        return numbs.length == 2;
    }

    public boolean checkNum(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }

    public int maxNumb(int a, int b) {
        return Math.max(a,b);
    }
}
