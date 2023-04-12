package ru.ivanovds.designPatterns.structural.decorator.inter.impl;

import ru.ivanovds.designPatterns.structural.decorator.inter.ChristmasTree;

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}
