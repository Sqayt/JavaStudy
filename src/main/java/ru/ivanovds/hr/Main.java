package ru.ivanovds.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public Main() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main mainApp = new Main();

        int s;
        int n;
        int m;

        try {
            s = scanner.nextInt();
            n = scanner.nextInt();
            m = scanner.nextInt();

            if (1 > m || m > 10000) throw new NumberFormatException("Неправильно введено число");
            if (1 > n || n > 10000) throw new NumberFormatException("Неправильно введено число");
            if (1 > s || s > 200000000) throw new NumberFormatException("Неправильно введено число");
        } catch (NumberFormatException ex) {
            System.err.println("Введите правильные числа");
            return;
        } finally {
            scanner.nextLine();
        }

        String[][] array = new String[mainApp.maxNumb(s, n)][2];

        // Заполнение матрицы
        for (String[] value : array) {
            String[] num = scanner.nextLine().split(" ");
            if (mainApp.checkArray(num))
                System.arraycopy(num, 0, value, 0, value.length);
            else {
                return;
            }
        }

        // Поиск значений
        int sum = 0;
        List<Integer> lstSum = new ArrayList<>();
        int count = 0;
        boolean isMoveHorizontal = false;

        for (int i = 0; i < array.length;) {
            for (int j = 0; j < array[i].length;) {
                if (sum < m && i < array.length - 1) {
                    int tmp;
                    if (j == 0) {
                        int tmpLeftUp = mainApp.checkNum(array[i + 1][j]) ? Integer.parseInt(array[i + 1][j]) : 0;
                        int tmpRightMid = mainApp.checkNum(array[i][j + 1]) ? Integer.parseInt(array[i][j + 1]) : 0;

                        if (i < array.length - 1 && isMoveHorizontal && tmpLeftUp != 0) {
                            tmp = tmpLeftUp;
                            i += 1;
                            isMoveHorizontal = false;
                        } else {
                            tmp = mainApp.minNumb(tmpRightMid, tmpLeftUp);
                            if (tmp == tmpRightMid && tmp != 0) {
                                j += 1;
                                isMoveHorizontal = true;
                            } else {
                                i += 1;
                            }
                        }

                        if (tmp == 0) return;

                        lstSum.add(tmp);
                        sum += tmp;
                        count++;
                    } else if (j == 1){
                        int tmpRightUp = mainApp.checkNum(array[i + 1][j]) ? Integer.parseInt(array[i + 1][j]) : 0;
                        int tmpLeftMid = mainApp.checkNum(array[i][j - 1]) ? Integer.parseInt(array[i][j - 1]) : 0;

                        if (i < array.length - 1 && isMoveHorizontal && tmpRightUp != 0) {
                            tmp = tmpRightUp;
                            i += 1;
                            isMoveHorizontal = false;
                        } else {
                            tmp = mainApp.minNumb(tmpRightUp, tmpLeftMid);
                            if (tmp == tmpLeftMid && tmp != 0) {
                                j -= 1;
                                isMoveHorizontal = true;
                            } else {
                                i += 1;
                            }
                        }

                        if (tmp == 0) return;

                        lstSum.add(tmp);
                        sum += tmp;
                        count++;
                    }
                } else  {
                    break;
                }
            }
            break;
        }

        while (true) {
            if (sum > m) {
                lstSum.remove(lstSum.size() - 1);
                count--;
            } else {
                break;
            }
        }

        scanner.close();
        System.out.println(count);
    }

    public boolean checkArray(String[] numbs) {
        if (numbs.length == 2) {
            for (String nums : numbs) {
                int num = checkNum(nums) ? Integer.parseInt(nums) : 99;
                if (1 > num || num > 10000) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
    public int minNumb(int a, int b) {
        int min = Math.min(a,b);

        if (min != 0) {
            return min;
        } else {
            if (a == 0) return b;
            else return a;
        }
    }
}