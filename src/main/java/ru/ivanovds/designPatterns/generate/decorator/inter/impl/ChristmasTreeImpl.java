package ru.ivanovds.designPatterns.generate.decorator.inter.impl;

import ru.ivanovds.designPatterns.generate.decorator.inter.ChristmasTree;

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}
