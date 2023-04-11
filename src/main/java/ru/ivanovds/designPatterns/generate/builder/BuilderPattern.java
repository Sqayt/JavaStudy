package ru.ivanovds.designPatterns.generate.builder;

import ru.ivanovds.designPatterns.generate.builder.models.Person;
import ru.ivanovds.designPatterns.generate.builder.models.Vehicle;

public class BuilderPattern {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        Person myPerson = new Person.Builder()
                .withName("Danil")
                .withSurName("Ivanov")
                .withAge(23)
                .withHeight(180)
                .withWeight(80)
                .build();
    }
}
