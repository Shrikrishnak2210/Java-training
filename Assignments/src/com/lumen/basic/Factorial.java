package com.lumen.basic;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int factorial = 1;
		int i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int number = scanner.nextInt();
		for (i = 1; i <= number; i++) {
			factorial *= i;
		}
		System.out.println("Factorial of " + number + " is " + factorial);
		scanner.close();
	}

}
