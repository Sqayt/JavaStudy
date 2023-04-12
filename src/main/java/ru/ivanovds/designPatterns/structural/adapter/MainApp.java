package ru.ivanovds.designPatterns.structural.adapter;

import ru.ivanovds.designPatterns.structural.adapter.inter.ShortMessage;
import ru.ivanovds.designPatterns.structural.adapter.models.Letter;
import ru.ivanovds.designPatterns.structural.adapter.models.ShortMessageLetterAdapter;

public class MainApp {

    public static void main(String[] args) {
        Letter letter = new Letter("You are won a million dollars!");
        ShortMessageLetterAdapter adapter = new ShortMessageLetterAdapter(letter);
        System.out.println(createTitle(adapter));
    }

    public static String createTitle(ShortMessage shortMessage) {
        return "New message: " + shortMessage.getShortMessage();
    }
}
