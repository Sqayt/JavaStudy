package ru.ivanovds.designPatterns.creational.prototype;

import ru.ivanovds.designPatterns.creational.prototype.inter.Prototype;

public class Human implements Prototype {

    private String name;
    private String lastName;
    private int age;

    public Human() {
        System.out.println("""
            
            Human description
            -----------------------------------
            Name\tLastName\tAge""");

    }

    public Human(String name, String lastName, int age) {
        this();
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        showHuman();
    }

    private void showHuman() {
        System.out.println(name + "\t" + lastName + "\t" + age);
    }

    @Override
    public Prototype getClone() {
        return new Human(name, lastName, age);
    }

    public static void main(String[] args) {
        Human human = new Human("Erwan", "Le Tutor", 30);
        Human human1 = (Human) human.getClone();
    }
}
