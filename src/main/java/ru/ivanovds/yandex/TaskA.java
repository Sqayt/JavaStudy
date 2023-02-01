package ru.ivanovds.yandex;

import java.util.*;
import java.util.stream.Stream;

public class TaskA {

    public static void main(String[] args) {
        TaskA taskA = new TaskA();
        Scanner scanner = new Scanner(System.in);
        System.out.println(taskA.game(scanner));
        scanner.close();
    }

    public String equation(int a, int b, int c, int d) {
        if (a == 0 && b == 0) {
            return "INF";
        } else if (a == 0 || b * c == a * d) {
            return "NO";
        } else if (b % a == 0) {
            int x = -b / a;
            return String.valueOf(x);
        } else {
            return "NO";
        }
    }

    public void parallelogram(int countTasks, Scanner scanner) {
        for (int i = 0; i < countTasks; i++) {
            int[] answer = new int[8];

            for (int j = 0; j < 8; j++) {
                int position = scanner.nextInt();
                answer[j] = position;
            }

            int x = (answer[0] + answer[2]) - (answer[4] + answer[6]);
            int y = (answer[1] + answer[3]) - (answer[5] + answer[7]);
            if (x == 0 && y == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public String game(Scanner scanner) {
        List<List<Integer>> matrix = fillMatrix(scanner);

        return isValidMatrix(matrix) ? "YES" : "NO";
    }

    private boolean isValidMatrix(List<List<Integer>> matrix) {
        int max1 = 0;
        int max2 = 0;
        for (List<Integer> integers : matrix) {
            for (int tmpNum : integers) {
                if (tmpNum == 1) {
                    max1++;
                }
                if (tmpNum == 2) {
                    max2++;
                }
            }
        }
        boolean isValid = !(max1 == 0 && max2 == 0);

        return max1 - max2 >= -1 && max1 - max2 <= 1 && isValid;
    }

    private List<List<Integer>> fillMatrix(Scanner scanner) {
        List<List<Integer>> matrix = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            List<Integer> row = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                int num = scanner.nextInt();
                row.add(num);
            }

            matrix.add(row);
        }

        return matrix;
    }

    private void printMatrix(List<List<Integer>> matrix) {
        matrix.stream().forEach(it -> {
            it.stream().forEach(el -> System.out.print(el + " "));
            System.out.println();
        });
    }
}
