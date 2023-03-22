package ru.ivanovds.Pools;

public class Polls {
    public static void main(String[] args) {
        Polls polls = new Polls();
        polls.intPool();
    }

    public void stringPool() {
        String one = "one"; // автоматом в пулл строк
        String two = new String("one").intern(); // благодаря команде intern() добавлен в пул
        String third = new String("one"); // находиться в куче

        System.out.println(one.equals(two));
        System.out.println(one == two);
        System.out.println(one == third);
        System.out.println(one == two);
    }

    public void intPool() {
        Integer one = 1;
        int two = 1;
        Integer third = new Integer(1);

        System.out.println(one == third);
        System.out.println(third);
    }
}
