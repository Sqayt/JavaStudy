package ru.ivanovds.designPatterns.creational.builder.models;

import lombok.Getter;
import lombok.Setter;

/*
    Первая реализация
 */

@Getter @Setter
public
class Vehicle {
    private String engine;
    private int wheel;
    private int airbags;

    public Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private final String engine;
        private final int wheel;
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
