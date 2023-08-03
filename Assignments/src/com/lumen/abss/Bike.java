package com.lumen.abss;

public class Bike extends Vehicle {

	public Bike(String model, String brand, float price) {
		super(model, brand, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	void getMileage() {
		// TODO Auto-generated method stub
		System.out.println("Mileage is 70 Km");
	}

	@Override
	void showType() {
		// TODO Auto-generated method stub
		System.out.println("Type: Naked sport");
	}
	
	void engineType() {
		System.out.println("Engine: Inline V4");
	}
	
}
