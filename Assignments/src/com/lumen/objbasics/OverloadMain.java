package com.lumen.objbasics;

import java.util.Scanner;

public class OverloadMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scanner.nextLine();
		System.out.println("Enter designation");
		String designation = scanner.nextLine();
		if (designation.equals("Programmer")) {
			Employee employee = new Employee(name, designation);
			System.out.println("Bonus is " + employee.calcBonus(4_000));
		} else if (designation.equals("Manager")) {
			Employee employee = new Employee(name, designation);
			System.out.println("Bonus is " + employee.calcBonus(10_000, 4_000));
		} else if (designation.equals("Director")) {
			Employee employee = new Employee(name, designation);
			System.out.println("Bonus is " + employee.calcBonus(40_000, 20_000, 10_000));

		} else {
			System.out.println("Invalid values");
		}
		scanner.close();

	}
}
