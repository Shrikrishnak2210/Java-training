package com.lumen.abss;

public class Car extends Vehicle {

	public Car(String model, String brand, float price) {
		super(model, brand, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	void getMileage() {
		// TODO Auto-generated method stub
		System.out.println("Mileage is 15 Km");
	}

	@Override
	void showType() {
		// TODO Auto-generated method stub
		System.out.println("Type Sports");
	}

	String[] showAccessories() {
		String[] accessories = new String[] { "car cover","seat cover", "rear camera", "dash camera" };
		return accessories;
	}
}
