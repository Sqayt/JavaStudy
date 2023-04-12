package ru.ivanovds.designPatterns.creational.factory;

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
 *
 * 	Фабричный метод (Factory method) также известный как Виртуальный конструктор (Virtual Constructor) - порождающий
 *  шаблон проектирования, определяющий общий интерфейс создания объектов в родительском классе и позволяющий изменять
 *  создаваемые объекты в дочерних классах.
 *
 * 	Фабричный метод (Factory method) ослабляет код соединения, отделяя контруктивный код нашего продукта от кода,
 *  который использует этот продукт. Такая конструкция позволяет легко извлекать конструкция конструкцию изделия
 *  независимо от остальной части приложения.
 */

public class FactoryPattern {
	public static void main(String[] args) {
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);
		
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}

}
