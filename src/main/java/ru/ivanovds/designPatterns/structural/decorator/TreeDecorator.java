package ru.ivanovds.designPatterns.structural.decorator;

import ru.ivanovds.designPatterns.structural.decorator.inter.ChristmasTree;

public class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    public TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}
