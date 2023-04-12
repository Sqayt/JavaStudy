package ru.ivanovds.designPatterns.structural.adapter.models;

public class Letter {

    private String message;

    public Letter(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
