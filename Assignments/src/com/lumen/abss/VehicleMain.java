package com.lumen.abss;

public class VehicleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Bike("Panigale V4", "Ducati", 600000);
		Bike bike2 = (Bike)vehicle;
		bike2.printDetails();
		bike2.getMileage();
		bike2.showType();
		bike2.engineType();

		vehicle = new Car("Koeniggseg Gemera", "Koeniggseg", 93000000);
		Car car = (Car)vehicle;
		car.printDetails();
		car.getMileage();
		car.showType();
		String[] access = car.showAccessories();
		for (String accessory : access) {
			System.out.print(accessory + ", ");
		}
	}

}
