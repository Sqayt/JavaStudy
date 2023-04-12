package ru.ivanovds.GB.Lesson6HM.models;

import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
public class Laptop {

    public Laptop(Long id, int ram, double sizeHardDrive, String os, String color) {
        this.id = id;
        this.ram = ram;
        this.sizeHardDrive = sizeHardDrive;
        Os = os;
        this.color = color;
    }

    private Long id;
    private int ram;
    private double sizeHardDrive;
    private String Os;
    private String color;
}
