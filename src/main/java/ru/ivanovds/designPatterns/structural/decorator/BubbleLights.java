package ru.ivanovds.designPatterns.structural.decorator;

import ru.ivanovds.designPatterns.structural.decorator.inter.ChristmasTree;

public class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
