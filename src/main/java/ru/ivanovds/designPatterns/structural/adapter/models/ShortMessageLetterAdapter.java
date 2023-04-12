package ru.ivanovds.designPatterns.structural.adapter.models;

import ru.ivanovds.designPatterns.structural.adapter.inter.ShortMessage;

public class ShortMessageLetterAdapter implements ShortMessage {

    private Letter letter;

    public ShortMessageLetterAdapter(Letter letter) {
        this.letter = letter;
    }

    @Override
    public String getShortMessage() {
        return letter.getMessage().substring(0, 5);
    }
}
