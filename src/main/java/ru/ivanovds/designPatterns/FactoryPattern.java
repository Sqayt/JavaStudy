package ru.ivanovds.designPatterns;

abstract class Vehicle {
	public abstract int getWheel();
	
	@Override
	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

class Car extends Vehicle {

	int wheel;
	
	Car(int wheel) {
		this.wheel = wheel;
	}
	
	@Override
	public int getWheel() {
		return this.wheel;
	}
	
}

class Bike extends Vehicle {

	int wheel;
	
	Bike(int wheel) {
		this.wheel = wheel;
	}
	
	@Override
	public int getWheel() {
		return this.wheel;
	}
	
}

class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		Vehicle vec;
		switch(type) {
			case "car":
				vec = new Car(wheel);
				break;
			case "bike":
				vec = new Bike(wheel);
				break;
			default:
				vec = null;
				break;
		}
		
		return vec;
	}
}

/*
 * 	Шаблон Factory - это один из наиболее часто используемых шаблонов проектирования.
 * 	Это шаблон создание объекта. Здесь мы не раскрываем логику, и ссылаемся на вновь созданный объект, 
 * 	используемый общий интерфейс.
 */

public class FactoryPattern {
	public static void main(String[] args) {
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);
		
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}

}
