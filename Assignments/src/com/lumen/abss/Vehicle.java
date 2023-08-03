package com.lumen.abss;

abstract public class Vehicle {
	String model;
	String brand;
	float price;

	public Vehicle(String model, String brand, float price) {
		super();
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	void printDetails() {
		System.out.println("Model " + model);
		System.out.println("Brand " + brand);
		System.out.println("Price Rs. " + price);
	}

	abstract void getMileage();

	abstract void showType();
}
