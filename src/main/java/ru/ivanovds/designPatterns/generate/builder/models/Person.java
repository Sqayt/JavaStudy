package ru.ivanovds.designPatterns.generate.builder.models;

import java.util.Set;

public class Person {

    private String name;
    private String surName;
    private int age;
    private int height;
    private int weight;
    private Set<Person> parents;

    public static class Builder {
        private final Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder withName(String name) {
            newPerson.name = name;
            return this;
        }

        public Builder withSurName(String surName) {
            newPerson.surName = surName;
            return this;
        }

        public Builder withAge(int age) {
            newPerson.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            newPerson.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            newPerson.weight = weight;
            return this;
        }

        public Builder withParents(Set<Person> parents) {
            newPerson.parents = parents;
            return this;
        }

        public Person build() {
            return newPerson;
        }
    }

}
