package ru.ivanovds.designPatterns.generate.decorator;

import ru.ivanovds.designPatterns.generate.decorator.inter.ChristmasTree;

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
